package com.example.cgtable.controller;

import com.example.cgtable.common.CommonResult;
import com.example.cgtable.entity.vo.OrderInfo;
import com.example.cgtable.entity.vo.PageCgOrderVo;
import com.example.cgtable.entity.vo.ResultCgOrder;
import com.example.cgtable.service.CgOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api(description = "订单信息")
@CrossOrigin
public class CgOrderController {
    //注入对象
    @Autowired
    private CgOrderService cgOrderService;
    @PostMapping("/add")
    @ApiOperation("新增订单信息")
    public CommonResult add(@RequestBody(required = false)OrderInfo orderInfo){
        Boolean aBoolean = cgOrderService.add(orderInfo);
        if (aBoolean){
           return CommonResult.success().message("新增成功");
        }
        return CommonResult.fail().message("新增失败");
    }
    @PostMapping("/query")
    @ApiOperation("条件查询")
    public CommonResult query(@RequestBody(required = true) PageCgOrderVo pageCgOrderVo){

        ResultCgOrder query = cgOrderService.query(pageCgOrderVo);
        return CommonResult.success().data("data",query);
    }
    @PostMapping("/edit")
    @ApiOperation("修改order信息")
    public CommonResult edit(@RequestBody(required = false)OrderInfo orderInfo){
        Boolean aBoolean =   cgOrderService.edit(orderInfo);
        return null;
    }

}
