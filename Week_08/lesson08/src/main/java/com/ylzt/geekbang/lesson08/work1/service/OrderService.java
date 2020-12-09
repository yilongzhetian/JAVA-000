package com.ylzt.geekbang.lesson08.work1.service;

import com.ylzt.geekbang.lesson08.domain.Order;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/8 11:31 下午
 **/
public interface OrderService {

    void insert(Long userId);

    void delete(Long userId,Long orderId);

    Order find(Long userId,Long orderId);
}
