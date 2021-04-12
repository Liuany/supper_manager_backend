package com.example.xiaochun.controller.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.controller.BaseController;
import com.example.xiaochun.model.dto.LoginDTO;
import com.example.xiaochun.model.entity.sys.Menu;
import com.example.xiaochun.model.vo.MemberInfoVo;
import com.example.xiaochun.service.sys.MenuService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {

    @Resource
    private MenuService menuService;

    @GetMapping("/loadMenu")
    public ApiResult<List<Menu>> loadMenu () {
        List<Menu> results = menuService.list();
        return ApiResult.success(results,"查询成功");
    }

    @GetMapping("/getMenuByPage")
    public ApiResult<Page<Menu>> getMenuByPage(@RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                       @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
        Page<Menu> list = menuService.getList(new Page<>(pageNo, pageSize));
        return ApiResult.success(list);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> save(@Valid @RequestBody Menu menu){
        boolean result = menuService.save(menu);
        if (result) {
            return ApiResult.success();
        }else {
            return ApiResult.failed("新增失败");
        }
    }
}
