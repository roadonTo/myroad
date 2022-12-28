package road.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 和数据库建立连接
 * 1.添加jar包
 * 2.加载驱动
 * 3.通过驱动管理器获取连接对象（准备url,用户名，密码）
 * <p>
 * Demo02,03,04,05分别是 增删改查的示例
 */
public class Demo01 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/fruit";
        String user = "root";
        String pwd = "root";
        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}


















