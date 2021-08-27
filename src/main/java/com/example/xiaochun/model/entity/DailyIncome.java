package com.example.xiaochun.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Builder
@Accessors(chain = true)
@TableName("sm_daily_income")
@NoArgsConstructor
@AllArgsConstructor
public class DailyIncome {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 日期
     */
    @TableField("date")
    private Date date;

    /**
     * 销售件数
     */
    @TableField("sales_count")
    private int salesCount;

    /**
     * 销售面值
     */
    @TableField("sales_price")
    private double salesPrice;

    /**
     * 应收现金
     */
    @TableField("cash_receivable")
    private double cashReceivable;

    /**
     * 实收现金
     */
    @TableField("cash_receipts")
    private double cashReceipts;

    /**
     * 刷卡
     */
    @TableField("card_income")
    private double cardIncome;

    /**
     * 微收
     */
    @TableField("we_chat_income")
    private double weChatIncome;

    /**
     * 券减免
     */
    @TableField("ticket_reduce")
    private double ticketReduce;

    /**
     * 充值抵扣
     */
    @TableField("balance")
    private double balance;

    /**
     * 记账
     */
    @TableField("tally")
    private double tally;

    /**
     * 备用金
     */
    @TableField("fund")
    private double fund;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 最后操作人
     */
    @TableField("operator")
    private String operator;
}
