package com.xasmall.lab9.repository;

import com.xasmall.lab9.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends CrudRepository<Blog,Long> {

//    通过解析方法名创建查询
    Blog findByTitle(String title);

    Blog findByTitleAndAuthor(String title,String author);

    @Query("from Blog b where b.title=:title")
    Blog findBlog(@Param("title") String title);
}
