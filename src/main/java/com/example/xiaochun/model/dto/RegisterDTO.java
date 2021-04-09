package com.example.xiaochun.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class RegisterDTO implements Serializable {

    private static final long serialVersionUID = -3041153883480365310L;

    @NotEmpty
    @Length(min = 2, max = 10, message = "长度在 2-10 个字符")
    private String userName;
    @NotEmpty
    @Length(min = 2, max = 10, message = "长度在 2-10 个字符")
    private String nickName;
    @NotEmpty
    @Length(min = 6, max = 20, message = "长度在 6-20 个字符")
    private String passWord;
    @NotEmpty
    @Length(min = 6, max = 20, message = "长度在 6-20 个字符")
    private String checkPassWord;
}
