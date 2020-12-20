package com.ylzt.geekbang.lesson09.work1.rpcfx.core.api;

import lombok.Data;

@Data
public class RpcfxRequest {

  private String serviceClass;

  private String method;

  private Object[] params;
}
