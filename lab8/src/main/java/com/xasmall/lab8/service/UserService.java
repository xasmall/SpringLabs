package com.xasmall.lab8.service;

import com.xasmall.lab8.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 新增一个用户
     */
    int addUser(String name,Integer age);

    /**
     * 根据name查询用户
     */
    List<User> getByName(String name);


    /**
     * 根据name删除用户
     */
    int deleteByName(String name);

    /**
     * 获取用户总量
     */
    int getAllUsers();

    /**
     * 删除所有用户
     */
    int deleteAllUsers();
}
