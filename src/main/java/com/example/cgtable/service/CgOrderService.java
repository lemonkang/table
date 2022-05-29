package com.example.cgtable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cgtable.entity.CgOrder;
import com.example.cgtable.entity.vo.OrderInfo;
import com.example.cgtable.entity.vo.PageCgOrderVo;
import com.example.cgtable.entity.vo.ResultCgOrder;

public interface CgOrderService extends IService<CgOrder> {
    Boolean add(OrderInfo orderInfo);

    ResultCgOrder query(PageCgOrderVo pageCgOrderVo);

    Boolean edit(OrderInfo orderInfo);
}
