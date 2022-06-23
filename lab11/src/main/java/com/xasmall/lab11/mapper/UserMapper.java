package com.xasmall.lab11.mapper;

import com.xasmall.lab11.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    User findByName(@Param("name") String name);

    int insert(@Param("name") String name, @Param("age") Integer age);
}
