package com.ylzt.gateway.router.impl;

import com.ylzt.gateway.router.HttpEndpointRouter;

import java.util.List;
import java.util.Random;

/**
 * @ClassName: RadomHttpEndpointRouter
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/5 12:10 上午
 **/
public class RandomHttpEndpointRouter implements HttpEndpointRouter {

    private  Random random=new Random();

    @Override
    public String route(List<String> endpoints) {
        int size=endpoints.size();
        int index=random.nextInt(size);
        return  endpoints.get(index);
    }
}
