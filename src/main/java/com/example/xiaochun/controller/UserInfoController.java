package com.example.xiaochun.controller;

import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.model.dto.LoginDTO;
import com.example.xiaochun.model.dto.RegisterDTO;
import com.example.xiaochun.model.entity.UserInfo;
import com.example.xiaochun.service.UserInfoService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.example.xiaochun.jwt.JwtUtil.USER_NAME;

@RestController
@RequestMapping("/sm/user")
public class UserInfoController extends BaseController  {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto){
        UserInfo userInfo = userInfoService.executeRegister(dto);
        if (ObjectUtils.isEmpty(userInfo)) {
            return ApiResult.failed("账号注册失败");
        }
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("user" , userInfo);
        return ApiResult.success(map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> login(@Valid @RequestBody LoginDTO dto){
        String token = userInfoService.executeLogin(dto);
        if(ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号或密码错误");
        }
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("token", token);
        System.out.println("token = " + token);
        return ApiResult.success(map, "登录成功");
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public ApiResult<UserInfo> getUser(@RequestHeader(value = USER_NAME) String userName) {
        UserInfo userInfo = userInfoService.getUserByUserName(userName);
        return ApiResult.success(userInfo);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult<Object> logOut() {
        return ApiResult.success(null, "注销成功");
    }
}
