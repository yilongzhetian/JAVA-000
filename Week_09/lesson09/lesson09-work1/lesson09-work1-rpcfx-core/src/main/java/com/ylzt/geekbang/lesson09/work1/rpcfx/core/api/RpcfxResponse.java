package com.ylzt.geekbang.lesson09.work1.rpcfx.core.api;

import lombok.Data;

@Data
public class RpcfxResponse {

    private Object result;

    private boolean status;

    private Exception exception;

}
