package com.xasmall.lab8.controller;

import com.xasmall.lab8.bean.User;
import com.xasmall.lab8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        int t = userService.addUser(user.getName(),user.getAge());
        if(t>0){
            return "success";
        }else{
            return "fail";
        }
    }

    // 注意PostMapping不支持GetMapping操作
    @GetMapping("/getUserByName")
    public List getUserByName(String name){
        List<User> users = userService.getByName(name);
        return users;
    }
}
