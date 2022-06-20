package com.xasmall.lab3.controller;

import com.xasmall.lab3.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    public List<User> getUserList(){
        List<User> r = new ArrayList<>(users.values());
        return r;
    }

    @PostMapping("/")
    public String postUser(@RequestBody User user){
        // RequestBody注解用来绑定http请求中application/json类型上传的数据
        users.put(user.getId(),user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        // url中的id可通过pathVariable绑定到函数的参数中
        return users.get(id);
    }

    @PostMapping("/{id}")
    public String getUser(@PathVariable Long id,@RequestBody User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
