package com.ylzt.lesson11.redis.pubsub.domain;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: Order
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2021/1/7 12:58 上午
 **/
@Data
public class Order {

    private String orderNo;//订单编号

    private Integer userId;//用户id

    private Date createdAt;//创建时间


}
