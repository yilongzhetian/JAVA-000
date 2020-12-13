package com.ylzt.geekbang.lesson08.work1.repository;
import com.ylzt.geekbang.lesson08.work1.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: OrderRepository
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/9 12:41 上午
 **/
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    int deleteOrderByUserIdAndOrderId(Long userId,Long orderId);

    Order findOrderByUserIdAndOrderId(Long userId,Long orderId);
}
