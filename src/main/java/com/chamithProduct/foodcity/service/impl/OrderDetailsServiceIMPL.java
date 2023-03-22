package com.chamithProduct.foodcity.service.impl;

import com.chamithProduct.foodcity.repo.OrderDetailRepo;
import com.chamithProduct.foodcity.util.mappers.OrderDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceIMPL {
    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
}
