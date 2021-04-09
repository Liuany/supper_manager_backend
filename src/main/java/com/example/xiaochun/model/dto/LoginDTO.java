package com.example.xiaochun.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 7266932812320969153L;

    @NotEmpty
    @Length(min = 2, max = 10, message = "长度在 2-10 个字符")
    private String userName;
    @NotEmpty
    @Length(min = 6, max = 20, message = "长度在 6-20 个字符")
    private String passWord;

    private String rememberMe;
}
