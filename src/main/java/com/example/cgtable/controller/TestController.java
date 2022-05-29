package com.example.cgtable.controller;

import com.example.cgtable.common.CommonResult;
import com.example.cgtable.entity.CgOrder;
import com.example.cgtable.mapper.CgOrderMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Api(description = "测试模块")
public class TestController {
    @Autowired(required = false)
    CgOrderMapper cgOrderMapper;
    @ApiOperation("测试全局异常处理器")
    @GetMapping("/exception")
    public CommonResult exception(){

        return CommonResult.success();
    }
    @ApiOperation("测试逻辑删除与自动填充")
    @PostMapping("/autoconfig")
    public CommonResult autoconfig(@RequestBody(required = false)CgOrder cgOrder){
        CgOrder cgOrder1 = new CgOrder();

        int insert = cgOrderMapper.insert(cgOrder1);
        if (insert==1){
            return CommonResult.success().message("新增成功");
        }
        return CommonResult.fail().message("新增失败");

    }

}
