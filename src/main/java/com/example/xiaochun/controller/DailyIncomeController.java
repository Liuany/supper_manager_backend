package com.example.xiaochun.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.model.entity.DailyIncome;
import com.example.xiaochun.model.vo.DailyIncomeVo;
import com.example.xiaochun.service.DailyIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sm/daily/")
public class DailyIncomeController extends BaseController{

    @Resource
    private DailyIncomeService dailyIncomeService;

    @GetMapping("/getListByPage")
    public ApiResult<Page<DailyIncomeVo>> getListByPage(@RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
        Page<DailyIncomeVo> list  = dailyIncomeService.getList(new Page<>(pageNo, pageSize));
        return ApiResult.success(list);
    }
}
