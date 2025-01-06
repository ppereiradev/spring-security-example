package dev.ppereira.springsecurityexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ppereira.springsecurityexample.model.request.LoginRequestModel;
import dev.ppereira.springsecurityexample.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestModel loginRequestModel) {

        return authService.getToken(loginRequestModel);
    }
}
