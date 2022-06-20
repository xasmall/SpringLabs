package com.xasmall.lab1.propertiesConfig;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "xasmall.blog")
@AllArgsConstructor
@NoArgsConstructor
public class BlogProperties {

    private String name;

}
