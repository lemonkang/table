package com.example.cgtable.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订单机票信息")
public class OrderFlightVo {
    @ApiModelProperty("航班id")
    private String flightID;
    @ApiModelProperty("航班号")
    private String flightNum;
    @ApiModelProperty("航班时间")
    private LocalDateTime flightTime;

}
