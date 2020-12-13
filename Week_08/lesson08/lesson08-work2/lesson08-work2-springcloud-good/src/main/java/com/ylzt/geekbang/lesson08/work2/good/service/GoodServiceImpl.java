package com.ylzt.geekbang.lesson08.work2.good.service;

import com.ylzt.geekbang.lesson08.work2.good.mapper.GoodMapper;
import com.ylzt.lesson08.work2.common.dto.GoodDTO;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: GoodServiceImpl
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 11:20 下午
 **/
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean decrease(GoodDTO goodDTO) {
        return goodMapper.decrease(goodDTO)>0;
    }

    @HmilyTCC(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    @Transactional
    @Override
    public void decreaseWithException(GoodDTO goodDTO) {
        throw new HmilyRuntimeException("库存不足");
    }

    public boolean confirm(GoodDTO goodDTO){

        return  goodMapper.confirm(goodDTO)>0;

    }

    public  boolean cancel(GoodDTO goodDTO){

        return  goodMapper.cancel(goodDTO)>0;
    }


}
