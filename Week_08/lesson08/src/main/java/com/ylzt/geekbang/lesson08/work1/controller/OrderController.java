package com.ylzt.geekbang.lesson08.work1.controller;

import com.ylzt.geekbang.lesson08.domain.Order;
import com.ylzt.geekbang.lesson08.work1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/9 12:48 上午
 **/
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}/{orderId}")
    public Order find(@PathVariable  Long userId,@PathVariable Long orderId){
        return orderService.find(userId,orderId);
    }

    @PostMapping("/{userId}")
    public String save(@PathVariable Long userId){
          orderService.insert(userId);
          return  "succes";
    }

    @DeleteMapping("/{userId}/{orderId}")
    public String delete(@PathVariable Long userId,@PathVariable Long orderId){
        orderService.delete(userId,orderId);
        return "succes";
    }
}
