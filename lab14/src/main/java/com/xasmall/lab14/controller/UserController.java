package com.xasmall.lab14.controller;

import com.xasmall.lab14.bean.User;
import com.xasmall.lab14.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        userMapper.insert(user.getName(), user.getAge());
        log.info("用户的姓名为: "+user.getName());
        return "success";
    }

    @GetMapping("/getUserByName")
    public User getUserByName(String name) {
        log.info("测试name: "+name);
        User user = userMapper.findByName(name);
        return user;
    }
}
