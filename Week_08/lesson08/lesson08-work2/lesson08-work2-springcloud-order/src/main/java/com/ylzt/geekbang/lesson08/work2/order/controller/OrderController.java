package com.ylzt.geekbang.lesson08.work2.order.controller;

import com.ylzt.geekbang.lesson08.work2.order.entity.Order;
import com.ylzt.geekbang.lesson08.work2.order.service.OrderService;
import com.ylzt.lesson08.work2.common.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/13 6:37 上午
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/save")
    public boolean save(@RequestBody OrderDTO orderDTO){
        Order order=orderService.save(orderDTO);
        return orderService.updateOrderStatus(order);
    }

    @PostMapping("/order/exception")
    public void saveWithException(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.save(orderDTO);
        boolean result = orderService.updateOrderStatusWithException(order);
    }

}
