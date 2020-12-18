package com.ylzt.geekbang.lesson09.work1.rpcfx.core.api;

public interface Filter {

    boolean filter(RpcfxRequest request);

    Filter next();

}
