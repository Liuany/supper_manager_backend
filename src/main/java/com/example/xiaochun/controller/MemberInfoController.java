package com.example.xiaochun.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.model.vo.MemberInfoVo;
import com.example.xiaochun.service.MemberInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/memberInfo")
public class MemberInfoController extends BaseController  {

    @Resource
    private MemberInfoService memberInfoService;

    @GetMapping("/getListByPage")
    public ApiResult<Page<MemberInfoVo>> getListByPage(@RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                     @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
        Page<MemberInfoVo> list = memberInfoService.getList(new Page<>(pageNo, pageSize));
        return ApiResult.success(list);
    }
}
