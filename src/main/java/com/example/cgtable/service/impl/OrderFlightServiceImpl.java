package com.example.cgtable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cgtable.entity.OrderFlight;
import com.example.cgtable.mapper.OrderFlightMapper;
import com.example.cgtable.service.OrderFlightService;
import org.springframework.stereotype.Service;

@Service
public class OrderFlightServiceImpl extends ServiceImpl<OrderFlightMapper, OrderFlight> implements OrderFlightService {
}
