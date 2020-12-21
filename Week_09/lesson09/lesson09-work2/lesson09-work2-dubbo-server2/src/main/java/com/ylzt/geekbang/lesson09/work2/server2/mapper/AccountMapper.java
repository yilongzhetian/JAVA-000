package com.ylzt.geekbang.lesson09.work2.server2.mapper;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName: AccountMapper
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/20 2:37 下午
 **/
public interface AccountMapper {



    @Update("update account set usd_money=usd_money-#{dollar},cny_money=cny_money+#{cny} where account_id=#{accountB} and usd_money>0")
    int update(TradeDTO tradeDTO);


    @Update("update account set usd_money=usd_money+#{dollar}, cny_money=cny_money-#{cny} where account_id=#{accountB}")
    int cancel(TradeDTO tradeDTO);



}
