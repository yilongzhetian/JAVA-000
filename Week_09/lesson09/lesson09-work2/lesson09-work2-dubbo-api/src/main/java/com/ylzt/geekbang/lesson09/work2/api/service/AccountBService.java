package com.ylzt.geekbang.lesson09.work2.api.service;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;

/**
 * @ClassName: AccountBService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/20 8:14 上午
 **/
public interface AccountBService {

    boolean transfer(TradeDTO dto);

}
