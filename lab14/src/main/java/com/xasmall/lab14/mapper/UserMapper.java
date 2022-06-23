package com.xasmall.lab14.mapper;

import com.xasmall.lab14.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "user")
@Mapper
public interface UserMapper {

    @Cacheable(key = "#p0")
    User findByName(String name);

    @CachePut(key = "#p0+'insert'")
    int insert(String name,Integer age);
}
