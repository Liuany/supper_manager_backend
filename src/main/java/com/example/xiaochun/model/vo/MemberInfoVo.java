package com.example.xiaochun.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class MemberInfoVo implements Serializable {

    private static final long serialVersionUID = 2834532070937806890L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * VIP编号
     */
    @TableField("code")
    private String code;
    /**
     * 姓名
     */
    @TableField("name")
    private String name;
    /**
     * 性别
     */
    @TableField("sex")
    private String sex;
    /**
     * 年龄
     */
    @TableField("age")
    private String age;
    /**
     * 出生日期
     */
    @TableField("birthday")
    private Date birthday;
    /**
     * 联系方式
     */
    @TableField("link_way")
    private String linkWay;
    /**
     * 会员级别
     */
    @TableField("level")
    private String level;
    /**
     * 常住地址
     */
    @TableField("address")
    private String address;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Timestamp updateTime;
    /**
     * 是否删除：N 否 ，Y 是
     */
    @TableField("is_del")
    private String isDel;
    /**
     *关联附件ID
     */
    @TableField("c_Uuid")
    private String cUuid;
}
