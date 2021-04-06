package com.example.xiaochun.controller;

import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.model.dto.RegisterDTO;
import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.service.MemberInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sm/user")
public class UserInfoController extends BaseController  {

    @Resource
    private MemberInfoService memberInfoService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto){
        List<MemberInfo> list = memberInfoService.list();
        return null;
    }
}
