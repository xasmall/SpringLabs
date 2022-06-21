package com.xasmall.lab9.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Entity注解标识了Blog类是一个持久化实体
@Entity
@Data
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;

    public Blog(String title,String author){
        this.title = title;
        this.author = author;
    }

}
