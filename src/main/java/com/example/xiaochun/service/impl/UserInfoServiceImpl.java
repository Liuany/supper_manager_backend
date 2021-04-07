package com.example.xiaochun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xiaochun.common.exception.ApiAsserts;
import com.example.xiaochun.jwt.JwtUtil;
import com.example.xiaochun.mapper.UserInfoMapper;
import com.example.xiaochun.model.dto.LoginDTO;
import com.example.xiaochun.model.dto.RegisterDTO;
import com.example.xiaochun.model.entity.UserInfo;
import com.example.xiaochun.service.UserInfoService;
import com.example.xiaochun.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo executeRegister(RegisterDTO dto) {
        //检查是否有相同的用户名和昵称
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<UserInfo>();
        wrapper.eq(UserInfo::getUserName, dto.getUserName()).or().eq(UserInfo::getNikeName, dto.getNickName());
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(userInfo)) {
            System.out.println(userInfo);
            ApiAsserts.fail("账号或昵称已存在！");
        }
        UserInfo registeredUser = UserInfo.builder()
                .id(UUID.randomUUID().toString().replace("-",""))
                .userName(dto.getUserName())
                .nikeName(dto.getNickName())
                .passWord(MD5Utils.getPwd(dto.getPassWord()))
                .build();
        userInfoMapper.insert(registeredUser);
        return registeredUser;
    }

    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            UserInfo user = getUserByUserName(dto.getUserName());
            String encodePwd = MD5Utils.getPwd(dto.getPassWord());
            if(!encodePwd.equals(user.getPassWord())) {
                throw  new Exception("密码错误");
            }
            token = JwtUtil.generateToken(dto.getUserName());
        } catch (Exception e) {
            log.warn("用户不存在或密码验证失败=======>{" + dto.getUserName() + "}");
        }
        return token;
    }

    @Override
    public UserInfo getUserByUserName(String userName) {
        return userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserName, userName));
    }
}
