package com.example.cgtable.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订单信息分页查询")
public class PageCgOrderVo extends CgOrderVo{
    @ApiModelProperty("页码")
    private Integer pagecurrent;
    @ApiModelProperty("当前页多少条")
    private Integer pagesize;
}
