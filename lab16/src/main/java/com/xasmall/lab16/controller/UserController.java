package com.xasmall.lab16.controller;

import com.xasmall.lab16.exception.UserNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public void get(@PathVariable String id){
        throw new UserNotExistException("user not exist");
    }
}
