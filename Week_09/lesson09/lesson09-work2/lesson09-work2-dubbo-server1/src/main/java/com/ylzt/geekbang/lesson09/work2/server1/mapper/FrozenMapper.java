package com.ylzt.geekbang.lesson09.work2.server1.mapper;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;
import com.ylzt.geekbang.lesson09.work2.server1.entity.Frozen;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: FrozenMapper
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/20 2:41 下午
 **/
public interface FrozenMapper {

  /*  @Insert("insert into  frozen(account_id,uk_frozen,cny_frozen) " +
            " values(#{accountId},#{ukFrozen},#{cnyFrozen},#{status}) "
    )
    int save(Frozen frozen);*/


    @Update("update frozen set cny_frozen=cny_frozen+#{cny} where account_id=#{accountA}")
    int frozenCny(TradeDTO dto);


    @Update("update frozen set cny_frozen=cny_frozen-#{cny} where account_id=#{accountA} and cny_frozen>0")
    int unfrozenCny(TradeDTO dto);

}
