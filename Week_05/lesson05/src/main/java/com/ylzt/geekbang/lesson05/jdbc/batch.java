package com.ylzt.geekbang.lesson05.jdbc;

import java.sql.*;

/**
 * @ClassName: batch
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/11/19 12:39 上午
 **/
public class batch {

    public  static  void main(String args[]) {

        Connection conn = null;
        PreparedStatement psmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
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

        }
        }


}
