package com.example.xiaochun.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xiaochun.mapper.MemberInfoMapper;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.model.vo.MemberInfoVo;
import com.example.xiaochun.service.MemberInfoService;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoMapper, MemberInfo>
        implements MemberInfoService {

    @Override
    public Page<MemberInfoVo> getList(Page<MemberInfoVo> page) {
        // 查询话题
        Page<MemberInfoVo> iPage = this.baseMapper.selectListAndPage(page);
        return iPage;
    }
}
