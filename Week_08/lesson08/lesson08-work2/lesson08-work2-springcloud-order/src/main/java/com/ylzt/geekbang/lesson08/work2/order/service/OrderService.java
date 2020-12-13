package com.ylzt.geekbang.lesson08.work2.order.service;

import com.ylzt.geekbang.lesson08.work2.order.entity.Order;
import com.ylzt.lesson08.work2.common.dto.OrderDTO;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/13 6:08 上午
 **/
public interface OrderService {

    Order save(OrderDTO orderDTO);

    boolean updateOrderStatus(Order order);


    boolean updateOrderStatusWithException(Order order);




}
