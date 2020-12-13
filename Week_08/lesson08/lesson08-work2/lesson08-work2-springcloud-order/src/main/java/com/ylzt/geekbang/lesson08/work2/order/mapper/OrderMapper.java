package com.ylzt.geekbang.lesson08.work2.order.mapper;

import com.ylzt.geekbang.lesson08.work2.order.entity.Order;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: OrderMapper
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 10:57 下午
 **/
@Repository
public interface OrderMapper {

    @Update("insert into  t_order(user_id,good_id,amount,status,created_time,updated_time) " +
            " values(#{userId},#{goodId},#{amount},#{status},#{createdTime},#{updatedTime}) "
           )
    @Options(useGeneratedKeys = true,keyProperty = "orderId",keyColumn = "order_id")
    void save(Order order);

    @Update("update  t_order set " +
            " status = #{status} where order_id=#{orderId}")
    int update(Order Order);

}
