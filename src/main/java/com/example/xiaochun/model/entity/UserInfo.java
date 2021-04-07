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
@TableName("sm_user_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 660839296303936447L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 密码
     */
    @TableField("pass_word")
    private String passWord;
    /**
     * 昵称
     */
    @TableField("nike_name")
    private String nikeName;
    /**
     * 角色ID
     */
    @TableField("role_id")
    private Date roleId;
    /**
     * 是否授权：0 否 ，1 是
     */
    @TableField("is_auth")
    private String isAuth;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
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
    private int isDel;
    /**
     *关联附件ID
     */
    @TableField("attach_id")
    private String attachId;
}
