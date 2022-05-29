package com.example.cgtable.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订单表")
public class CgOrderVo {
    @ApiModelProperty("订单id")
    private String orderId;
    @ApiModelProperty("订单号")
    private String orderNum;
    @ApiModelProperty("订单类型")
    private String orderType;
    @ApiModelProperty("订单金额")
    private BigDecimal orderMoney;
    @ApiModelProperty("订单备注")
    private String orderDescription;
    @ApiModelProperty("订单日期")
    private LocalDateTime orderDate;
}
