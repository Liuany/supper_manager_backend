package com.example.xiaochun.service.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xiaochun.model.entity.sys.Menu;

public interface MenuService extends IService<Menu> {

    Page<Menu> getList(Page<Menu> page);

}
