package com.ylzt.geekbang.lesson08.work2.good.controller;

import com.ylzt.geekbang.lesson08.work2.good.service.GoodService;
import com.ylzt.lesson08.work2.common.dto.GoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: GoodController
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/12 11:55 下午
 **/

@RestController
public class GoodController {
    @Autowired
    private GoodService goodService;

    @PostMapping("/good/decrease")
    public boolean decrease(@RequestBody GoodDTO goodDTO){
        return goodService.decrease(goodDTO);
    }

    @PostMapping("/good/exception")
    public void decreaseWithException(@RequestBody GoodDTO goodDTO){
        goodService.decreaseWithException(goodDTO);
    }



}
