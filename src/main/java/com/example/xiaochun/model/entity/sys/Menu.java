package com.example.xiaochun.model.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder
@Accessors
@TableName("sm_sys_menu")
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {

    private static final long serialVersionUID = 3735229573619124042L;

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
     * 父节点ID
     */
    @TableField("icon")
    private String icon;
    /**
     * 是否删除
     */
    @TableField("is_del")
    private String isDel;
}
