package com.ylzt.geekbang.lesson09.work2.server2.mapper;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName: FrozenMapper
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/20 2:41 下午
 **/
public interface FrozenMapper {



    @Update("update frozen set usd_frozen=usd_frozen+#{dollar} where account_id=#{accountB}")
    int frozenUk(TradeDTO dto);


    @Update("update frozen set usd_frozen=usd_frozen-#{dollar} where account_id=#{accountB} and usd_frozen>0")
    int unfrozenUk(TradeDTO dto);

}
