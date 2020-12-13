package com.ylzt.geekbang.lesson08.work2.order.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: Order
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 5:11 下午
 **/
@Data
public class Order {

    private Long orderId;

    private String status;

    private Long goodId;

    private Long userId;

    private int amount;

    private Date createdTime;

    private Date updatedTime;


}
