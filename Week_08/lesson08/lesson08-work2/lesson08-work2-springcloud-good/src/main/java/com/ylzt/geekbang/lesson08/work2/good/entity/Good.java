package com.ylzt.geekbang.lesson08.work2.good.entity;

import lombok.Data;
import java.util.Date;

/**
 * @ClassName: Order
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 5:11 下午
 **/
@Data
public class Good {

    private Long orderId;

    private Long userId;

    private Long goodId;

    private int amount;

    private int lockAmount;

    private Date createdTime;

    private Date updatedTime;


}
