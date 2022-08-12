package com.alphacode.handson.config;

import com.alphacode.handson.security.authentication.ApiKeyAuthenticationManager;
import com.alphacode.handson.security.authentication.preauth.ApiKeyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests().mvcMatchers("/v1/**").authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(this.apiKeyAuthenticationFilter(new ApiKeyAuthenticationManager()), UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
		return http.build();
	}

	@Bean
	public ApiKeyAuthenticationManager apiKeyAuthenticationManager() {
		return new ApiKeyAuthenticationManager();
	}

	@Bean
	public ApiKeyAuthenticationFilter apiKeyAuthenticationFilter(ApiKeyAuthenticationManager apiKeyAuthenticationManager) {
		return new ApiKeyAuthenticationFilter(apiKeyAuthenticationManager);
	}
}
