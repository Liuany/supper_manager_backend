package com.example.xiaochun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.model.vo.MemberInfoVo;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoMapper extends BaseMapper<MemberInfo> {

    /**
     * 分页查询会员列表
     *
     * @param page
     * @return
     */
    Page<MemberInfoVo> selectListAndPage(Page<MemberInfoVo> page);
}
