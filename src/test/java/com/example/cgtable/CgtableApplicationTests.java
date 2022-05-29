package com.example.cgtable;

import com.example.cgtable.entity.CgOrder;
import com.example.cgtable.entity.OrderCustom;
import com.example.cgtable.entity.vo.OrderCustomVo;
import com.example.cgtable.mapper.CgOrderMapper;
import com.example.cgtable.service.OrderCustomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CgtableApplicationTests {
    @Autowired(required = false)
    CgOrderMapper cgOrderMapper;
    @Autowired(required = false)
   private OrderCustomService customService;

    @Test
    public void contextLoads() {
    }
    @Test
    public void autoconfig(){
        CgOrder cgOrder = new CgOrder();
        System.out.println(cgOrder);
        int insert = cgOrderMapper.insert(cgOrder);


    }
    @Test
    public void copyProperties(){
        Ocean ocean = new Ocean("测试", 123);
        OceanCopy oceanCopy = new OceanCopy();
        BeanUtils.copyProperties(ocean,oceanCopy);
        System.out.println(oceanCopy);
    }
    @Test
    public void update(){
        OrderCustom orderCustom = new OrderCustom();
        OrderCustomVo orderCustomVo = new OrderCustomVo();
        orderCustomVo.setCustomId("342545");
        orderCustomVo.setCustomName("测试");
        BeanUtils.copyProperties(orderCustomVo,orderCustom);
        System.out.println(orderCustom);
        boolean b = customService.updateById(orderCustom);
        System.out.println(b);
    }

}
