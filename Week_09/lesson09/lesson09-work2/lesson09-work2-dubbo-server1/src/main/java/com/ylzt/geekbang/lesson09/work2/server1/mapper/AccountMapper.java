package com.ylzt.geekbang.lesson09.work2.server1.mapper;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;
import com.ylzt.geekbang.lesson09.work2.server1.entity.Frozen;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: AccountMapper
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/20 2:37 下午
 **/
public interface AccountMapper {



    @Update("update account set uk_money=uk_money+#{dollar},cny_money=cny_money-#{cny} where account_id=#{account_id} and cny_money>0")
    int update(TradeDTO tradeDTO);


    @Update("update account set uk_money=uk_money-#{dollar}, cny_money=cny_money+#{cny} where account_id=#{account_id}")
    int cancel(TradeDTO tradeDTO);



}
