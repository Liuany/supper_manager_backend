package com.example.xiaochun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xiaochun.mapper.MemberInfoMapper;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.service.MemberInfoService;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoMapper, MemberInfo>
        implements MemberInfoService {
}
