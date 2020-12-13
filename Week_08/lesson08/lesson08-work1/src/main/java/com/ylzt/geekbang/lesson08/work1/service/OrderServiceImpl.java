package com.ylzt.geekbang.lesson08.work1.service;

import com.ylzt.geekbang.lesson08.work1.domain.Order;
import com.ylzt.geekbang.lesson08.work1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/9 12:41 上午
 **/
@Service
public class OrderServiceImpl  implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void insert(Long userId) {
        Order order=new Order();
        order.setUserId(userId);
        order.setCreatedTime(new Date());
        order.setUpdatedTime(new Date());
        orderRepository.save(order);

    }

    @Transactional
    @Override
    public void delete(Long userId,Long orderId) {
        orderRepository.deleteOrderByUserIdAndOrderId(userId,orderId);
    }

    @Override
    public Order find(Long userId, Long orderId) {
        return orderRepository.findOrderByUserIdAndOrderId(userId,orderId);
    }
}
