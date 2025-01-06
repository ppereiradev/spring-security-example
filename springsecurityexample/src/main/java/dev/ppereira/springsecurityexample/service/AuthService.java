package dev.ppereira.springsecurityexample.service;

import org.springframework.stereotype.Service;

import dev.ppereira.springsecurityexample.model.request.LoginRequestModel;

@Service
public interface AuthService {

    String getToken(LoginRequestModel loginRequestModel);
}
