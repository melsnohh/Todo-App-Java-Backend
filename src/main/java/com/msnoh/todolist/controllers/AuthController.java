package com.msnoh.todolist.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

    @GetMapping("/basicauth")
    public String basicAuthCheck(){
        return "Success";
    }

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World v2";
    }

    @GetMapping("/hello-world-bean")
    public String helloWorldBean(){
        return "Hello World v1 Bean v1";
    }




}
