package com.example.xiaochun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xiaochun.model.dto.LoginDTO;
import com.example.xiaochun.model.dto.RegisterDTO;
import com.example.xiaochun.model.entity.UserInfo;

public interface UserInfoService extends IService<UserInfo> {

    /**
     * 注册功能
     *
     * @param dto
     * @return  注册对象
     */
    UserInfo executeRegister (RegisterDTO dto);

    /**
     *
     * @param dto
     * @return 生成JWT的token
     */
    String executeLogin (LoginDTO dto);

    /**
     *获取登录用户信息
     *
     * @param userName
     * @return 登录用户信息
     */
    UserInfo getUserByUserName(String userName);
}
