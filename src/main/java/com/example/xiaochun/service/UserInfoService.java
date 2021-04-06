package com.example.xiaochun.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
}
