package com.xasmall.lab2.controller;

import com.xasmall.lab2.propertiesConfig.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookConfig")
public class BookPropertiesController {

    @Autowired
    BookProperties bookProperties;

    @GetMapping("/getDesc")
    public String getDesc(){
        return bookProperties.getDesc()+"---"+bookProperties.getBigNumber();
    }
}
