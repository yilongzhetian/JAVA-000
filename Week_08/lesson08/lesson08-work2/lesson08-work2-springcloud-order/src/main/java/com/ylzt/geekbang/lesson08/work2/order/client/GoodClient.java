package com.ylzt.geekbang.lesson08.work2.order.client;

import com.ylzt.lesson08.work2.common.dto.GoodDTO;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName: GoodClient
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/13 6:24 上午
 **/
@FeignClient(value = "good-service")
public interface GoodClient {


    @PostMapping("/good/decrease")
    @Hmily
    boolean decrease(@RequestBody GoodDTO goodDTO);

    @PostMapping("/good/exception")
    @Hmily
    void decreaseWithException(@RequestBody GoodDTO goodDTO);

}
