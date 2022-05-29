package com.example.cgtable.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo extends CgOrderVo{
    private List<OrderCustomVo> orderCustomVos;
    private List<OrderFlightVo> orderFlightVos;
}
