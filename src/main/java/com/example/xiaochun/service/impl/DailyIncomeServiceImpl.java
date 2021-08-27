package com.example.xiaochun.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xiaochun.mapper.DailyIncomeMapper;
import com.example.xiaochun.model.entity.DailyIncome;
import com.example.xiaochun.model.vo.DailyIncomeVo;
import com.example.xiaochun.service.DailyIncomeService;
import org.springframework.stereotype.Service;

@Service
public class DailyIncomeServiceImpl extends ServiceImpl<DailyIncomeMapper, DailyIncome>
        implements DailyIncomeService {
    @Override
    public Page<DailyIncomeVo> getList(Page<DailyIncomeVo> page) {
        Page<DailyIncomeVo> iPage = this.baseMapper.selectListAndPage(page);
        return iPage;
    }
}
