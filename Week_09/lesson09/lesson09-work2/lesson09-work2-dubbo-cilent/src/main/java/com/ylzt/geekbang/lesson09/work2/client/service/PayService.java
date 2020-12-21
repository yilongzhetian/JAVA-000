package com.ylzt.geekbang.lesson09.work2.client.service;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;
import com.ylzt.geekbang.lesson09.work2.api.service.AccountAService;
import com.ylzt.geekbang.lesson09.work2.api.service.AccountBService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PayService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/21 12:47 上午
 **/

@Service
public class PayService {


    @DubboReference(
            version = "1.0.0",
            url = "dubbo://127.0.0.1:20880"
    )
    private AccountAService accountAService;

    @DubboReference(
            version = "1.0.0",
            url = "dubbo://127.0.0.1:20881"
    )
    private AccountBService accountBService;


    @HmilyTCC
    public void pay(TradeDTO tradeDTO){

        accountAService.transfer(tradeDTO);
        accountBService.transfer(tradeDTO);


    }

    @HmilyTCC
    public void payWithException(TradeDTO dto) {
        accountAService.transferWithException(dto);
        accountBService.transfer(dto);
    }
}
