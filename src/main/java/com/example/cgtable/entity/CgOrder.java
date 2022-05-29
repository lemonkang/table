package com.example.cgtable.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
@TableName("cg_order")
public class CgOrder {
    @TableId(value = "order_id",type = IdType.ID_WORKER_STR)
    private String orderId;
    private String orderNum;
    private String orderType;
    private BigDecimal orderMoney;
    private String orderDescription;
    private LocalDateTime orderDate;
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDelete;
    @TableField(fill =FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
