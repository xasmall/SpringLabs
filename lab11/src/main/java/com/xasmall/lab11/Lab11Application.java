package com.xasmall.lab11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xasmall.lab11.mapper ")
public class Lab11Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab11Application.class, args);
    }

}
