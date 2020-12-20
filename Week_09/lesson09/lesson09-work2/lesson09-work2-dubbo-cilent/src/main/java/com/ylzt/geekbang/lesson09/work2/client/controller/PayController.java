package com.ylzt.geekbang.lesson09.work2.client.controller;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;
import com.ylzt.geekbang.lesson09.work2.client.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: PayController
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/21 1:07 上午
 **/
@RestController
public class PayController {

    private  PayService payService;

    @Autowired
    public void setPayService(PayService payService){
        this.payService=payService;
    }


    @PostMapping(value = "/pay")
    public String pay(@RequestBody TradeDTO dto){
        payService.pay(dto);
        return "success";
    }

}
