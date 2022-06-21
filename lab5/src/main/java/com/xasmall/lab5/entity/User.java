package com.xasmall.lab5.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户实体")
public class User {

    @ApiModelProperty("用户编号")
    private Long id;

    @NotNull
    @Size(min = 2,max = 5) // 校验字符串长度
    @ApiModelProperty("用户姓名")
    private String name;

    @NotNull
    @Max(150)  // 限制数字的大小
    @Min(0)
    @ApiModelProperty("用户年龄")
    private Integer age;
}
