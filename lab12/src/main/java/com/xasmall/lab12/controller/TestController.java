package com.xasmall.lab12.controller;

import com.xasmall.lab12.annoation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Log("执行方法一")
    @GetMapping("/one")
    public  void methodOne(String name){
        System.out.println("hhhh");
    }

    @Log("执行方法二")
    @GetMapping("/two")
    public String methodTwo(String name,String age){
        return name + ":" + age;
    }
}
