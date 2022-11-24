package com.road;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 使用 配置文件方式 连接数据库
 */
public class JdbcUtils {
    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;

    static {

        try{
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"); //db.properties放在src下面
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            //驱动只用加载一次
            Class.forName(driver);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    //释放连接资源
    public static void release(Connection conn, PreparedStatement stmt, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

