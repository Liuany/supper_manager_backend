package com.example.xiaochun.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class MenuVo implements Serializable{

    private static final long serialVersionUID = 7451468963007085451L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 菜单名
     */
    @TableField("name")
    private String name;
    /**
     * 路由
     */
    @TableField("path")
    private String path;
    /**
     * 是否父节点
     */
    @TableField("is_parent")
    private String isParent;
    /**
     * 父节点ID
     */
    @TableField("p_id")
    private String pid;
    /**
     * 父节点名称
     */
    @TableField("p_name")
    private String pName;
    /**
     * 图标
     */
    @TableField("icon")
    private String icon;
    /**
     * 是否删除
     */
    @TableField("is_del")
    private String isDel;
}
