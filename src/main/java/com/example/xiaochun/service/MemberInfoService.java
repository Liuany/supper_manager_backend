package com.example.xiaochun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.model.vo.MemberInfoVo;

public interface MemberInfoService extends IService<MemberInfo> {
    /**
     * 分页返回
     *
     * @param page MyBatisPlus Page对象
     * @return
     */
    Page<MemberInfoVo> getList(Page<MemberInfoVo> page);
}
