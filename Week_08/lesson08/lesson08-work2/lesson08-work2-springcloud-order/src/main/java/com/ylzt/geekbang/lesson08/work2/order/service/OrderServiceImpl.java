package com.ylzt.geekbang.lesson08.work2.order.service;

import com.ylzt.geekbang.lesson08.work2.order.client.GoodClient;
import com.ylzt.geekbang.lesson08.work2.order.entity.Order;
import com.ylzt.geekbang.lesson08.work2.order.mapper.OrderMapper;
import com.ylzt.lesson08.work2.common.dto.GoodDTO;
import com.ylzt.lesson08.work2.common.dto.OrderDTO;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/13 6:09 上午
 **/
@Service
public class OrderServiceImpl  implements OrderService{

    @Autowired
    private GoodClient goodClient;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order save(OrderDTO orderDTO) {
        Order order= buildOrder(orderDTO);
        orderMapper.save(order);
        return order;
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean updateOrderStatus(Order order) {

        return goodClient.decrease(buildGoodDTO(order));
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean updateOrderStatusWithException(Order order) {
        goodClient.decreaseWithException(buildGoodDTO(order));
        return false;
    }


    public boolean confirm(Order order){
        order.setStatus("success");
        return orderMapper.update(order)>0;

    }

    public  boolean cancel(Order order){
        order.setStatus("fail");
        return  orderMapper.update(order)>0;
    }

    private Order buildOrder(OrderDTO orderDTO){
        Order order=new Order();
        order.setUserId(orderDTO.getUserId());
        order.setAmount(orderDTO.getAmount());
        order.setGoodId(orderDTO.getGoodId());
        order.setCreatedTime(new Date());
        order.setUpdatedTime(new Date());
        return  order;
    }

    private  GoodDTO buildGoodDTO(Order order){
        GoodDTO goodDTO=new GoodDTO();
        goodDTO.setCount(order.getAmount());
        goodDTO.setId(order.getGoodId());
        return  goodDTO;

    }

}
