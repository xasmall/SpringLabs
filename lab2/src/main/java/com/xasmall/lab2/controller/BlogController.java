package com.xasmall.lab2.controller;

import com.xasmall.lab2.bean.Blog;
import com.xasmall.lab2.propertiesConfig.BlogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogConfig blogConfig;

    @GetMapping("/blogList")
    public String blogList(){
        StringBuilder sb = new StringBuilder();
        for(Blog b : blogConfig.getList()){
            sb.append(b.getName());
            sb.append("-----");
            sb.append(b.getAuthor());
        }
        return sb.toString();
    }
}
