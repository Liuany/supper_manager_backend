package com.example.xiaochun.service.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.xiaochun.model.entity.sys.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return
     */
    Page<Menu> getList(Page<Menu> page);

    /**
     * 根据pid查询记录
     *
     * @param pid 父节点ID
     * @return
     */
    List<Menu> selectByPid(String pid);

    /**
     * 根据id删除记录
     *
     * @param id
     * @return
     */
    int delById(String id);
}
