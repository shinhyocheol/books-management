package com.example.app;

import java.sql.*;

public class CreateDatabase {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/?user=root&password=1234";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.hibernate.dialect.MySQL5InnoDBDialect");

            conn = DriverManager.getConnection(url);

            stmt = conn.createStatement();
            String existsSql = "DROP DATABASE IF EXISTS `store`;";
            String createSql = "CREATE DATABASE `store` DEFAULT CHARACTER SET = utf8";

            stmt.executeUpdate(existsSql);
            stmt.executeUpdate(createSql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {}
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch(SQLException e2) {}
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException e3) {}
            }
        }
    }
}
