package com.example.cgtable.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@TableName("order_custom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCustom {
    @TableId(value = "custom_id",type = IdType.ID_WORKER_STR)
    private String customId;
    private String customName;
    private Integer customSex;
    private String customIdcard;
    private Integer customPhone;
    private String orderId;
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDelete;
    @TableField(fill =FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
