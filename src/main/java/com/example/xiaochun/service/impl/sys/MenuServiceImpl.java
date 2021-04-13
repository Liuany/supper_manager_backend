package com.example.xiaochun.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xiaochun.mapper.sys.MenuMapper;
import com.example.xiaochun.model.entity.sys.Menu;
import com.example.xiaochun.model.vo.MemberInfoVo;
import com.example.xiaochun.service.sys.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
        implements MenuService {
    @Override
    public Page<Menu> getList(Page<Menu> page) {
        // 查询菜单
        Page<Menu> iPage = this.baseMapper.selectListAndPage(page);
        return iPage;
    }

    @Override
    public List<Menu> selectByPid(String pid) {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<Menu>();
        wrapper.eq(Menu::getPid, pid);
        List<Menu> list = this.baseMapper.selectList(wrapper);
        return list;
    }

    @Override
    public int delById(String id) {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<Menu>();
        wrapper.eq(Menu::getId, id);
        int count = this.baseMapper.delete(wrapper);
        return count;
    }
}
