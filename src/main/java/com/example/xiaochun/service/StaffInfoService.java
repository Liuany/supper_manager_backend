package com.example.xiaochun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xiaochun.model.entity.StaffInfo;
import com.example.xiaochun.model.entity.sys.Menu;
import com.example.xiaochun.model.vo.MemberInfoVo;
import com.example.xiaochun.model.vo.StaffInfoVo;

public interface StaffInfoService extends IService<StaffInfo> {

    /**
     * 分页返回
     *
     * @param page MyBatisPlus Page对象
     * @return
     */
    Page<StaffInfoVo> getList(Page<StaffInfoVo> page);

    /**
     * 根据id删除记录
     *
     * @param id
     * @return
     */
    int delById(String id);

    /**
     * 根据id删除记录
     *
     * @param staffInfo
     * @return
     */
    boolean saveOrUpdateStaff(StaffInfo staffInfo);

    /**
     * 查询员工信息
     * @param page
     * @param staffInfo
     * @return
     */
    Page<StaffInfo> searchMenuByPage(Page<StaffInfo> page, StaffInfo staffInfo);
}
