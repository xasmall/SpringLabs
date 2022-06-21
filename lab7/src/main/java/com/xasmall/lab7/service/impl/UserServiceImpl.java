package com.xasmall.lab7.service.impl;

import com.xasmall.lab7.bean.User;
import com.xasmall.lab7.service.UserService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    UserServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(String name, Integer age) {
        String sql = "insert into user(name,age) values(?,?)";
        return jdbcTemplate.update(sql,name,age);
    }

    @Override
    public List<User> getByName(String name) {
        String sql = "select name,age from user where name = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql,rowMapper,name);
    }

    @Override
    public int deleteByName(String name) {
        String sql = "delete from user where name = ?";
        return jdbcTemplate.update(sql,name);
    }

    @Override
    public int getAllUsers() {
        String sql = "select count(1) from user";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public int deleteAllUsers() {
        String sql = "delete from user";
        return jdbcTemplate.update(sql);
    }
}
