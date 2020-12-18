package com.ylzt.geekbang.lesson09.work1.rpcfx.core.api;

import java.util.List;

public interface LoadBalancer {

    String select(List<String> urls);

}
