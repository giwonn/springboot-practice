package com.alphacode.handson.security.authentication.preauth;

import com.alphacode.handson.security.authentication.ApiKeyAuthenticationManager;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class ApiKeyAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    private static final String API_KEY_HEADER_NAME = "x-api-key";

    public ApiKeyAuthenticationFilter(ApiKeyAuthenticationManager apiKeyAuthenticationManager) {
        this.setAuthenticationManager(apiKeyAuthenticationManager);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(API_KEY_HEADER_NAME);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }
}