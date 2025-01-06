package dev.ppereira.springsecurityexample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import dev.ppereira.springsecurityexample.model.request.LoginRequestModel;
import dev.ppereira.springsecurityexample.service.AuthService;
import dev.ppereira.springsecurityexample.utils.security.JwtUtils;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    private static final Integer EXPIRATION_TIME_IN_MINUTES = 15;

    @Override
    public String getToken(LoginRequestModel loginRequestModel) {

        Authentication authentication = authenticationManager.
            authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequestModel.getUsername(),
                    loginRequestModel.getPassword()
                )
            );

        return jwtUtils.generateToken(authentication, EXPIRATION_TIME_IN_MINUTES);
    }


}
