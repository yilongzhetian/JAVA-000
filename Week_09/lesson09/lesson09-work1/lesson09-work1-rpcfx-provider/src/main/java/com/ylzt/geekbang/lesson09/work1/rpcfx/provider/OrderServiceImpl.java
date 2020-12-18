package com.ylzt.geekbang.lesson09.work1.rpcfx.provider;


import com.ylzt.geekbang.lesson09.work1.rpcfx.api.Order;
import com.ylzt.geekbang.lesson09.work1.rpcfx.api.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
