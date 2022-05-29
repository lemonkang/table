package com.example.cgtable.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订单客户信息")
public class OrderCustomVo {
    @ApiModelProperty("客户id")
    private String customId;
    @ApiModelProperty("客户名")
    private String customName;
    @ApiModelProperty("性别")
    private Integer customSex;
    @ApiModelProperty("身份证号")
    private String customIdcard;
    @ApiModelProperty("手机号")
    private Integer customPhone;

}
