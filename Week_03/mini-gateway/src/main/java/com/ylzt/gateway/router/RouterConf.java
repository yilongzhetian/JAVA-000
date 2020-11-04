package com.ylzt.gateway.router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RouterConf
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/5 12:20 上午
 **/
public class RouterConf {

    public static Map<String, List<String>> endpointsMap=new HashMap<>();

    static {
        registerMapping("/test","http://127.0.0.1:8081");
        registerMapping("/test","http://127.0.0.1:8082");
        registerMapping("/test","http://127.0.0.1:8083");

    }


    public static void registerMapping(String uri,String endpoints){
        List<String> list= endpointsMap.get(uri);
        if(list==null){
            list=new ArrayList<>();
            endpointsMap.put(uri,list);
        }
        list.add(uri);
    }



}
