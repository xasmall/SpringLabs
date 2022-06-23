package com.xasmall.lab11.controller;

import com.xasmall.lab11.bean.User;
import com.xasmall.lab11.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        userMapper.insert(user.getName(), user.getAge());
        log.debug("输出一个日志，用来测试...."+user.getName());
        return "success";
    }

    @GetMapping("/getUserByName")
    public User getUserByName(String name) {
        User user = userMapper.findByName(name);
        return user;
    }
}
