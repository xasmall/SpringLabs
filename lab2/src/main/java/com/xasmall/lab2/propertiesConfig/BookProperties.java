package com.xasmall.lab2.propertiesConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookProperties {

    private String name;

    private String author;

    private String desc;

    private int value;

    private long bigNumber;
}
