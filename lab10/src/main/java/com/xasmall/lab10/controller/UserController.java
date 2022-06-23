package com.xasmall.lab10.controller;

import com.xasmall.lab10.bean.User;
import com.xasmall.lab10.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userMapper.insert(user.getName(),user.getAge());
        return "success";
    }

    @GetMapping("/getUserByName")
    public User getUserByName(String name){
        User user = userMapper.findByName(name);
        return user;
    }
}
