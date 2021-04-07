package com.example.xiaochun.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {

    @NotEmpty
    @Length(min = 2, max = 10, message = "长度在 2-10 个字符")
    private String userName;
    @NotEmpty
    @Length(min = 6, max = 20, message = "长度在 6-20 个字符")
    private String passWord;

    private String rememberMe;
}
