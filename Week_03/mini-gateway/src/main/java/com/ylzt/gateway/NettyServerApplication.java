package com.ylzt.gateway;

import com.ylzt.gateway.inbound.netty.HttpInBoundHandler;
import com.ylzt.gateway.inbound.netty.HttpInBoundServer;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: NettyServerApplication
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/3 11:45 下午
 **/
@Slf4j
public class NettyServerApplication {

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "1.0.0";

    public static void main(String[] args) {
        String proxyPort = System.getProperty("proxyPort", "8888");

        //  http://localhost:8888/api/hello  ==> gateway API
        //  http://localhost:8088/api/hello  ==> backend service

        int port = Integer.parseInt(proxyPort);
        log.info(GATEWAY_NAME + " " + GATEWAY_VERSION + " starting...");
        HttpInBoundServer server = new HttpInBoundServer(port);
        log.info(GATEWAY_NAME + " " + GATEWAY_VERSION + " started at http://localhost:" + port );
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
