package com.example.xiaochun.controller.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.common.api.ApiResult;
import com.example.xiaochun.controller.BaseController;
import com.example.xiaochun.model.entity.sys.Menu;
import com.example.xiaochun.service.sys.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
        boolean result = menuService.saveOrUpdate(menu);
        if (result) {
            return ApiResult.success();
        }else {
            return ApiResult.failed("新增失败");
        }
    }

    @GetMapping("/getByPid")
    public ApiResult<List<Menu>> getByPid (@RequestParam(value = "pid") String pid) {
        List<Menu> list = menuService.selectByPid(pid);
        return ApiResult.success(list,"查询成功");
    }

    @RequestMapping(value = "/delById", method = RequestMethod.DELETE)
    public ApiResult<Integer> delById (@RequestParam(value = "id") String id) {
        int count = menuService.delById(id);
        return ApiResult.success(count,"删除成功");
    }

    @RequestMapping(value = "/searchMenuByPage", method = RequestMethod.POST)
    public ApiResult<Page<Menu>> searchMenuByPage (@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @Valid @RequestBody Menu menu) {
        Page<Menu> list = menuService.searchMenuByPage(new Page<>(pageNo, pageSize), menu);
        return ApiResult.success(list,"查询成功");
    }
}
