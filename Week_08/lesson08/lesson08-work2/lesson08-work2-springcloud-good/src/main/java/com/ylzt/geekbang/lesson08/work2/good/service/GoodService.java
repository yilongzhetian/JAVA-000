package com.ylzt.geekbang.lesson08.work2.good.service;

import com.ylzt.lesson08.work2.common.dto.GoodDTO;

/**
 * @ClassName: GoodService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 11:18 下午
 **/
public interface GoodService {

    boolean decrease(GoodDTO goodDTO);

    void decreaseWithException(GoodDTO goodDTO);


}
