package com.example.xiaochun.controller;

import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/memberInfo")
public class MemberInfoController extends BaseController  {

    @Resource
    private MemberInfoService memberInfoService;

    @GetMapping("/getListByPage")
    public ApiResult<MemberInfo> getListByPage(){
        List<MemberInfo> list = memberInfoService.list();
        return ApiResult.success(list.get(0));
    }
}
