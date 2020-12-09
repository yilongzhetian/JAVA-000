package com.ylzt.geekbang.lesson08.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/5 10:40 下午
 **/
@Data
@Entity
@Table(name = "t_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;


}
