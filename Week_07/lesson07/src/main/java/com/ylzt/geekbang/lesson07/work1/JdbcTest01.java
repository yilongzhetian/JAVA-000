package com.ylzt.geekbang.lesson07.work1;

import java.sql.*;
import java.util.Random;

/**
 * @ClassName: JdbcTest
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/1 11:55 下午
 **/
public class JdbcTest01 {

    public  static  void main(String args[]){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shop?useSSL=false", "root", "");
            PreparedStatement psmt = connection.prepareStatement("insert into t_user(name,phone,created_time,updated_time) VALUES(?,?,NOW(),now());");
            Long startTime=System.currentTimeMillis();
            insertOne(psmt);//一次提交一条
            insert1000(psmt,connection);//一次提交1000条
            insert10000(psmt,connection);//一次提交10000条
            psmt.close();
            connection.close();
            Long endTime=System.currentTimeMillis();
            System.out.println("耗时:"+(endTime-startTime)/1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void insertOne(PreparedStatement psmt) throws  Exception{
        Random random=new Random();
        for(int i=1;i<=1000000;i++) {//一次一条提交
            psmt.setString(1,"李"+i);
            psmt.setString(2, "135136"+(random.nextInt(900000)+100000));
            psmt.execute();
        }
    }

    private static void insert1000(PreparedStatement psmt,Connection connection) throws  Exception{
        connection.setAutoCommit(false);
        Random random=new Random();
        for(int i=1;i<=1000;i++) {
            for (int j = 1; j <= 1000; j++) {//每1000条数据插入一次
                psmt.setString(1,"李"+i*j);
                psmt.setString(2, "135136"+(random.nextInt(900000)+100000));
                psmt.addBatch();
            }
            psmt.executeBatch();
            connection.commit();
        }
    }

    private static void insert10000(PreparedStatement psmt,Connection connection) throws  Exception {
        connection.setAutoCommit(false);
        Random random=new Random();
        for(int i=1;i<=100;i++) {
            for (int j = 1; j <= 10000; j++) {//每10000条数据插入一次
                psmt.setString(1,"李"+i*j);
                psmt.setString(2, "135136"+(random.nextInt(900000)+100000));
                psmt.addBatch();
            }
            psmt.executeBatch();
            connection.commit();

        }
    }


}

