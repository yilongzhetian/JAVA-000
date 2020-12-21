package com.ylzt.geekbang.lesson09.work2.server1.service;

import com.ylzt.geekbang.lesson09.work2.api.dto.TradeDTO;
import com.ylzt.geekbang.lesson09.work2.api.service.AccountAService;
import com.ylzt.geekbang.lesson09.work2.server1.mapper.AccountMapper;
import com.ylzt.geekbang.lesson09.work2.server1.mapper.FrozenMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: AccountAServiceImpl
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/20 2:31 下午
 **/
@DubboService(version = "1.0.0")
public class AccountAServiceImpl implements AccountAService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private FrozenMapper frozenMapper;


    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    @Transactional
    @Override
    public boolean transfer(TradeDTO dto) {
        buildTradeDTO(dto);
        return accountMapper.update(dto)>0&&frozenMapper.frozenCny(dto)>0;
    }

    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    @Transactional
    @Override
    public boolean transferWithException(TradeDTO dto) {
        throw new HmilyRuntimeException("账户A转账失败");
    }


    public  boolean confirm(TradeDTO dto){
        buildTradeDTO(dto);
        return  frozenMapper.unfrozenCny(dto)>0;
    }


    public  boolean cancel(TradeDTO dto)
    {
        buildTradeDTO(dto);
        return frozenMapper.unfrozenCny(dto)>0&&accountMapper.cancel(dto)>0;
    }




    private void buildTradeDTO(TradeDTO tradeDTO){
        int dollar=tradeDTO.getDollar();
        tradeDTO.setCny(dollar*7);
    }

}
