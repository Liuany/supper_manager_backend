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
@TableName("sm_staff_info")
@NoArgsConstructor
@AllArgsConstructor
public class StaffInfo implements Serializable {

    private static final long serialVersionUID = -6626707484815445710L;
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 员工编号
     */
    @TableField("staff_code")
    private String staffCode;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 职位编码
     */
    @TableField("position_code")
    private String positionCode;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private Date birthday;

    /**
     * 所属门店编码
     */
    @TableField("belongs_code")
    private String belongsCode;

    /**
     * 联系方式
     */
    @TableField("link_way")
    private String linkWay;

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
}
