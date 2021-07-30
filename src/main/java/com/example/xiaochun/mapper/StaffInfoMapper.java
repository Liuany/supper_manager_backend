package com.example.xiaochun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.model.entity.StaffInfo;
import com.example.xiaochun.model.vo.MemberInfoVo;
import com.example.xiaochun.model.vo.StaffInfoVo;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffInfoMapper extends BaseMapper<StaffInfo> {

    /**
     * 分页查询会员列表
     *
     * @param page
     * @return
     */
    Page<StaffInfoVo> selectListAndPage(Page<StaffInfoVo> page);

    /**
     * 获取最大员工编码
     *
     * @param belongsCode
     * @return
     */
    String selectMaxStaffCode(String belongsCode);
}
