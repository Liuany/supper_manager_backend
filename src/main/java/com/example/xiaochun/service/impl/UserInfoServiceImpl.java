package com.example.xiaochun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xiaochun.mapper.UserInfoMapper;
import com.example.xiaochun.model.dto.RegisterDTO;
import com.example.xiaochun.model.entity.UserInfo;
import com.example.xiaochun.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo executeRegister(RegisterDTO dto) {
        UserInfo registeredUser = UserInfo.builder()
                .userName(dto.getUserName())
                .nikeName(dto.getNickName())
                .passWord(dto.getPassWord())
                .build();
        userInfoMapper.insert(registeredUser);
        return registeredUser;
    }
}
