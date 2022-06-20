package com.xasmall.lab2.controller;

import com.xasmall.lab2.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookBeanController {

    @Autowired
    Book book;

    @GetMapping("/getBookName")
    public String getBookName(){
        System.out.println("heeell");
        return book.getName();
    }
}
