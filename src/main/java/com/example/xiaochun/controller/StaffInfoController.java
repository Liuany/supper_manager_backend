package com.example.xiaochun.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.model.entity.StaffInfo;
import com.example.xiaochun.model.entity.sys.Menu;
import com.example.xiaochun.model.vo.StaffInfoVo;
import com.example.xiaochun.service.StaffInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("sm/staff")
public class StaffInfoController extends BaseController  {

    @Resource
    private StaffInfoService staffInfoService;

    @GetMapping("/getListByPage")
    public ApiResult<Page<StaffInfoVo>> getListByPage(@RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                     @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
        Page<StaffInfoVo> list = staffInfoService.getList(new Page<>(pageNo, pageSize));
        return ApiResult.success(list);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> save(@Valid @RequestBody StaffInfo staffInfo){
        boolean result = staffInfoService.saveOrUpdateStaff(staffInfo);
        if (result) {
            return ApiResult.success();
        }else {
            return ApiResult.failed("新增失败");
        }
    }

    @RequestMapping(value = "/delById", method = RequestMethod.DELETE)
    public ApiResult<Integer> delById (@RequestParam(value = "id") String id) {
        int count = staffInfoService.delById(id);
        return ApiResult.success(count,"删除成功");
    }

    @RequestMapping(value = "/searchStaffByPage", method = RequestMethod.POST)
    public ApiResult<Page<StaffInfo>> searchMenuByPage (@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @Valid @RequestBody StaffInfo staffInfo) {
        Page<StaffInfo> list = staffInfoService.searchMenuByPage(new Page<>(pageNo, pageSize), staffInfo);
        return ApiResult.success(list,"查询成功");
    }
}
