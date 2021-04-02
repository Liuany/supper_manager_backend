package com.example.xiaochun.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
@Accessors(chain = true)
@TableName("sm_member_info")
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo implements Serializable {

    private static final long serialVersionUID = -2822047271579732890L;
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
     * 是否删除：0 否 ，1 是
     */
    @TableField("is_del")
    private int isDel;
    /**
     *关联附件ID
     */
    @TableField("c_Uuid")
    private String cUuid;
}
