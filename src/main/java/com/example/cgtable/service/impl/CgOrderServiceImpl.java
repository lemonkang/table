package com.example.cgtable.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cgtable.entity.CgOrder;
import com.example.cgtable.entity.OrderCustom;
import com.example.cgtable.entity.OrderFlight;
import com.example.cgtable.entity.vo.*;
import com.example.cgtable.mapper.CgOrderMapper;
import com.example.cgtable.service.CgOrderService;
import com.example.cgtable.service.OrderCustomService;
import com.example.cgtable.service.OrderFlightService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CgOrderServiceImpl extends ServiceImpl<CgOrderMapper, CgOrder> implements CgOrderService {


    //注入客户信息service对象
    @Autowired(required = false)
    private OrderCustomService orderCustomService;
    //注入机票信息service对象
    @Autowired(required = false)
    private OrderFlightService orderFlightService;
    /**
     * 增加订单信息
     * @param orderInfo
     * @return
     */
    @Override
    public Boolean add(OrderInfo orderInfo) {
        //订单信息
        CgOrder cgOrder = new CgOrder();
        BeanUtils.copyProperties(orderInfo,cgOrder);
        boolean save = this.save(cgOrder);
        if (!save){
            throw  new RuntimeException("新增订单信息失败");
        }
        //客户信息
        boolean CustomNull = Objects.isNull(orderInfo.getOrderCustomVos());
        if (!CustomNull){
            List<OrderCustom> orderCustoms = orderInfo.getOrderCustomVos().stream().map(item -> {
                OrderCustom orderCustom = new OrderCustom();
                BeanUtils.copyProperties(item, orderCustom);
                orderCustom.setOrderId(cgOrder.getOrderId());
                return orderCustom;
            }).collect(Collectors.toList());
            boolean b = orderCustomService.saveBatch(orderCustoms);
            if (!b) {
                throw new RuntimeException("新增客户信息失败");
            }
        }
        //机票信息
        boolean FlightNull = Objects.isNull(orderInfo.getOrderFlightVos());
        if (!FlightNull){
            List<OrderFlight> orderFlights = orderInfo.getOrderFlightVos().stream().map(item -> {
                OrderFlight orderFlight = new OrderFlight();
                BeanUtils.copyProperties(item, orderFlight);
                orderFlight.setOrderId(cgOrder.getOrderId());
                return orderFlight;
            }).collect(Collectors.toList());
            boolean b = orderFlightService.saveBatch(orderFlights);
            if (!b){
                throw new RuntimeException("新增机票信息失败");
            }
        }

        return true;
    }

    /**
     * 条件查询
     */
    @Override
    public ResultCgOrder query(PageCgOrderVo pageCgOrderVo) {
        Page<CgOrder> page = new Page<>(pageCgOrderVo.getPagecurrent(),pageCgOrderVo.getPagesize());
        LambdaQueryWrapper<CgOrder> queryWrapper = new LambdaQueryWrapper<>();
        if (!Objects.isNull(pageCgOrderVo.getOrderType())){
            queryWrapper.eq(CgOrder::getOrderType,pageCgOrderVo.getOrderType());
        }
        if (!Objects.isNull(pageCgOrderVo.getOrderDate())){
            queryWrapper.eq(CgOrder::getOrderDate,pageCgOrderVo.getOrderDate());
        }
        if (!Objects.isNull(pageCgOrderVo.getOrderDescription())){
            queryWrapper.eq(CgOrder::getOrderDescription,pageCgOrderVo.getOrderDescription());
        }
        if (!Objects.isNull(pageCgOrderVo.getOrderNum())){
            queryWrapper.eq(CgOrder::getOrderNum,pageCgOrderVo.getOrderNum());
        }
        if (!Objects.isNull(pageCgOrderVo.getOrderMoney())){
            queryWrapper.eq(CgOrder::getOrderMoney,pageCgOrderVo.getOrderMoney());
        }
         this.page(page, queryWrapper);
        //封住返回信息
        ResultCgOrder resultCgOrder = new ResultCgOrder();
        if (!Objects.isNull( page.getRecords())){
            List<CgOrderVo> cgOrderVos = page.getRecords().stream().map(item -> {
                CgOrderVo cgOrderVo = new CgOrderVo();
                BeanUtils.copyProperties(item, cgOrderVo);
                return cgOrderVo;
            }).collect(Collectors.toList());
            resultCgOrder.setCgOrderVos(cgOrderVos);
            resultCgOrder.setTotal((int) page.getTotal());
        }




        return resultCgOrder;
    }

    /**
     * 修改订单信息
     * @param orderInfo
     * @return
     */
    @Override
    public Boolean edit(OrderInfo orderInfo) {
        //修改客户信息
        boolean aNull = Objects.isNull(orderInfo.getOrderCustomVos());
        if (!aNull){
            //根据订单ID取出所有客户信息id
            String orderId = orderInfo.getOrderId();
            LambdaQueryWrapper<OrderCustom> allcustoms = new LambdaQueryWrapper<>();

            allcustoms.eq(OrderCustom::getOrderId,orderId);
            List<OrderCustom> collectcustoms = orderCustomService.list(allcustoms);
            List<String> orderCustoms = collectcustoms.stream().map(item -> item.getCustomId()).collect(Collectors.toList());
            //筛选出新增的数据
            List<OrderCustomVo> OrderCustomcollect = orderInfo.getOrderCustomVos().stream().filter(item -> Objects.isNull(item) || Objects.equals("", item)).collect(Collectors.toList());
            List<OrderCustom> ordercustomcollects = OrderCustomcollect.stream().map(item -> {
                OrderCustom orderCustom = new OrderCustom();
                BeanUtils.copyProperties(item, orderCustom);
                return orderCustom;
            }).collect(Collectors.toList());
            boolean b = orderCustomService.saveBatch(ordercustomcollects);
            if (!b){
                throw new RuntimeException("客户信息修改失败");
            }
            //筛选出修改的数据
            List<OrderCustomVo> editorderCustomVos = orderInfo.getOrderCustomVos().stream().filter(item -> !Objects.equals("", item)).collect(Collectors.toList());
            List<OrderCustom> orderCustoms1 = editorderCustomVos.stream().map(item -> {
                OrderCustom orderCustom = new OrderCustom();
                BeanUtils.copyProperties(item, orderCustom);
                return orderCustom;
            }).collect(Collectors.toList());
            boolean b1 = orderCustomService.updateBatchById(orderCustoms1);

            //筛选出剩下要删除的数据
            List<String> collect = orderCustoms1.stream().map(item -> item.getCustomId()).collect(Collectors.toList());
            ArrayList<String> deletearr = new ArrayList<>();
            for (String item:orderCustoms) {
                if (collect.contains(item)){
                    deletearr.add(item);
                }
            }
            boolean b2 = orderCustomService.removeByIds(deletearr);


        }
        return null;
    }


}
