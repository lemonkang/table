package com.example.cgtable.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("航班信息")
public class OrderFlight {
    @TableId(value = "flight_id",type = IdType.ID_WORKER_STR)
    private String flightID;
    private String flightNum;
    private LocalDateTime flightTime;
    private String orderId;
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDelete;
    @TableField(fill =FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
