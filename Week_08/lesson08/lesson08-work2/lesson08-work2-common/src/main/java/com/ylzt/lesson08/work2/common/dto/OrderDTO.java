package com.ylzt.lesson08.work2.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: OrderDto
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 10:57 下午
 **/
@Data
public class OrderDTO {

    private Long userId;

    private Long goodId;

    private int amount;


}
