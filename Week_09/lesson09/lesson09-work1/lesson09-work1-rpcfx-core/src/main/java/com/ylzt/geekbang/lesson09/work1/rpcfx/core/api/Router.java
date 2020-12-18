package com.ylzt.geekbang.lesson09.work1.rpcfx.core.api;

import java.util.List;

public interface Router {

    List<String> route(List<String> urls);
}
