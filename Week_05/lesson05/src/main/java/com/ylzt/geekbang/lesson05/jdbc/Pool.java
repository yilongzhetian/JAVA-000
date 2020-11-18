package com.ylzt.geekbang.lesson05.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

/**
 * @ClassName: Pool
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/19 12:51 上午
 **/
public class Pool {

    public  static  void  main(String args[]){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql:///test");
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.setMaximumPoolSize(10);
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection conn = null;
        PreparedStatement psmt = null;
        try {
            conn=ds.getConnection();
            String sql = "insert into accounts(name,password) values(?,?)";
            conn.setAutoCommit(false);
            psmt=conn.prepareStatement(sql);
            for(int i=0;i<10;i++){
                psmt.setString(1,"小"+i);
                psmt.setString(2,"pwd"+i);
                psmt.addBatch();
            }
            psmt.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);

        }catch (Exception e){
            try {
                if(!conn.isClosed()){
                    conn.rollback();
                    conn.setAutoCommit(true);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }finally {
            try {
                psmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            ds.close();
        }
    }




}
