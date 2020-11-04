package com.ylzt.gateway.inbound.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: HttpInBoundInitializer
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/4 12:19 上午
 **/
@Slf4j
public class HttpInBoundInitializer extends ChannelInitializer<SocketChannel> {


    public HttpInBoundInitializer() {
    }



    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline p = socketChannel.pipeline();
//		if (sslCtx != null) {
//			p.addLast(sslCtx.newHandler(ch.alloc()));
//		}
        p.addLast(new HttpServerCodec());
        //p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new HttpInBoundHandler());
    }
}
