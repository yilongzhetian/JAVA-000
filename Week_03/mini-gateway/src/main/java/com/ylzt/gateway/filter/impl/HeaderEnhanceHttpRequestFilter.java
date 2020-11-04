package com.ylzt.gateway.filter.impl;

import com.ylzt.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * @ClassName: HeaderEnhanceRequestFilter
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/5 12:47 上午
 **/
public class HeaderEnhanceHttpRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
         HttpHeaders httpHeaders=fullRequest.headers();
         httpHeaders.add("nio","ylzt");
    }
}
