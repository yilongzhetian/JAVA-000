package com.ylzt.geekbang.lesson09.work1.rpcfx.provider;

import lombok.Data;

@Data
public class ServiceProviderDesc {

    private String host;
    private Integer port;
    private String serviceClass;

}
