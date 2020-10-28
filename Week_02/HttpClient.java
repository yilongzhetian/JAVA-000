package com.ylzt.geekbang.lesson04;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName: HttpClient
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/10/27 11:30 下午
 **/
public class HttpClient {

    public static void main(String args[]) throws IOException {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
     //   CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet("http://localhost:8801");
            CloseableHttpResponse response=httpclient.execute(httpget);
            HttpEntity httpEntity= response.getEntity();
            String content=httpEntity==null?"":EntityUtils.toString(httpEntity);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                httpclient.close();
        }
    }




}
