package com.alphacode.handson.security.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiKeyAuthenticationManager implements AuthenticationManager {

    private static final String API_KEY = "alphacode";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        if (!API_KEY.equals(principal)) {
            throw new BadCredentialsException("Invalid API KEY.");
        }
        authentication.setAuthenticated(true);
        return authentication;
    }
}