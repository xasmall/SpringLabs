package com.xasmall.lab9.controller;

import com.xasmall.lab9.bean.Blog;
import com.xasmall.lab9.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/addBlog")
    public String addBlog(@RequestBody Blog blog){
        blogRepository.save(blog);
        return "success";
    }

    @GetMapping("/findByTitle")
    public Blog findByTitle(String title){
        Blog blog = blogRepository.findByTitle(title);
        return blog;
    }

    @GetMapping("/getBlog")
    public Blog getBlog(String title){
        Blog blog = blogRepository.findBlog(title);
//        System.out.println();
        return blog;
    }
}
