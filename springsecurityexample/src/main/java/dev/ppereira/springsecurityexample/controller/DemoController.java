package dev.ppereira.springsecurityexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String home() {


        return "Welcome to the home page!";
    }

    @GetMapping("/users")
    public String user() {
        return "Welcome to the user page!";
    }
}
