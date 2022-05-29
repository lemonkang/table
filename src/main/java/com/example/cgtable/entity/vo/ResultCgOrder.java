package com.example.cgtable.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultCgOrder {
    private List<CgOrderVo> cgOrderVos;
    private Integer total;
}
