package com.example.xiaochun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xiaochun.mapper.StaffInfoMapper;
import com.example.xiaochun.model.entity.StaffInfo;
import com.example.xiaochun.model.vo.StaffInfoVo;
import com.example.xiaochun.service.StaffInfoService;
import com.example.xiaochun.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo>
        implements StaffInfoService {

    @Resource
    private StaffInfoService staffInfoService;

    @Resource
    private StaffInfoMapper staffInfoMapper;

    @Override
    public Page<StaffInfoVo> getList(Page<StaffInfoVo> page) {
        // 查询话题
        Page<StaffInfoVo> iPage = this.baseMapper.selectListAndPage(page);
        return iPage;
    }

    @Override
    public int delById(String id) {
        LambdaQueryWrapper<StaffInfo> wrapper = new LambdaQueryWrapper<StaffInfo>();
        wrapper.eq(StaffInfo::getId, id);
        int count = this.baseMapper.delete(wrapper);
        return count;
    }

    @Override
    public boolean saveOrUpdateStaff(StaffInfo staffInfo) {
        boolean result = true;
        try {
            //判断记录是否存在，不存在则生成员工编号
            if(!StringUtils.hasText(staffInfo.getId())){ //新增
                //生成员工编号
                String staffCode = generateStaffCode(staffInfo.getBelongsCode());
                //设置员工编号
                staffInfo.setStaffCode(staffCode);
                //设置ID
                staffInfo.setId(StringUtil.getUUID());
            }else{  //更新
                StaffInfo record = baseMapper.selectById(staffInfo.getId());
                if(null != record && !record.getBelongsCode().equals(staffInfo.getBelongsCode())){
                    String staffCode = generateStaffCode(staffInfo.getBelongsCode());
                    //设置员工编号
                    staffInfo.setStaffCode(staffCode);
                }
            }
            //保存或更新员工数据
            staffInfoService.saveOrUpdate(staffInfo);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return  result;
    }

    @Override
    public Page<StaffInfo> searchMenuByPage(Page<StaffInfo> page, StaffInfo staffInfo) {
        LambdaQueryWrapper<StaffInfo> queryWrapper = new LambdaQueryWrapper<StaffInfo>();
        queryWrapper.like(StaffInfo::getName, staffInfo.getName());
        Page<StaffInfo> iPage = staffInfoMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    public String generateStaffCode(String belongsCode){
        //获取当前最大员工编号
        String maxCode = baseMapper.selectMaxStaffCode(belongsCode);
        if(StringUtils.hasText(maxCode)){
            maxCode = Integer.parseInt(maxCode.replace(belongsCode, "")) + 1 + "";
            //规定允许最大的员工不超过3位数
            while(maxCode.length() < 3){
                maxCode = "0" + maxCode;
            }
            maxCode = belongsCode + maxCode;
        }else{
            maxCode = belongsCode + "001";
        }
        return  maxCode;
    }
}
