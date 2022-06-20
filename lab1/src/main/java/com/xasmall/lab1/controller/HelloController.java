package com.xasmall.lab1.controller;


import com.xasmall.lab1.propertiesConfig.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    BlogProperties blogProperties;

    @GetMapping("/index")
    public String index(){
        return blogProperties.getName();
    }
}
