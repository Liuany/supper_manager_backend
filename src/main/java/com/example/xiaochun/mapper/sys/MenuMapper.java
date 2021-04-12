package com.example.xiaochun.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xiaochun.model.entity.UserInfo;
import com.example.xiaochun.model.entity.sys.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    Page<Menu> selectListAndPage(Page<Menu> page);
}
