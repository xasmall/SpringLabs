package com.xasmall.lab2.propertiesConfig;

import com.xasmall.lab2.bean.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogConfig {
    private List<Blog> list;
}
