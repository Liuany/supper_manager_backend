package com.example.xiaochun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.model.entity.DailyIncome;
import com.example.xiaochun.model.vo.DailyIncomeVo;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyIncomeMapper extends BaseMapper<DailyIncome> {

    Page<DailyIncomeVo> selectListAndPage(Page<DailyIncomeVo> page);

}
