package com.ylzt.geekbang.lesson08.work2.good.mapper;

import com.ylzt.lesson08.work2.common.dto.GoodDTO;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: GoodMapper
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 6:27 下午
 **/
@Repository
public interface GoodMapper {

    @Update("update t_good set amount = amount - #{count}," +
            " lock_amount= lock_amount + #{count} " +
            " where id =#{id} and amount > 0  ")
    int decrease(GoodDTO goodDTO);

    @Update("update t_good set " +
            " lock_amount = lock_amount - #{count} " +
            " where id =#{id} and lock_amount > 0 ")
    int confirm(GoodDTO goodDTO);


    @Update("update t_good set amount = amount + #{count}," +
            " lock_amount= lock_amount - #{count} " +
            " where id =#{id}  and lock_amount > 0 ")
    int cancel(GoodDTO goodDTO);





}
