package com.example.xiaochun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xiaochun.model.entity.DailyIncome;
import com.example.xiaochun.model.vo.DailyIncomeVo;

public interface DailyIncomeService extends IService<DailyIncome> {

    /**
     * 获取日收入情况列表
     * @param page
     * @return
     */
    Page<DailyIncomeVo> getList(Page<DailyIncomeVo> page);
}
