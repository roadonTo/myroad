package road.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Fruit fruit = new Fruit(2, "苹果", "好甜的哟");
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.利用驱动管理器连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruit?useSSL=false&useUnicode=true&characterEncoding=utf-8", "root", "root");

        String sql = "update fruit set fname=? ,remark=? where fid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,fruit.getFname());
        statement.setString(2,fruit.getRemark());
        statement.setInt(3,fruit.getFid());

        int i = statement.executeUpdate();
        System.out.println(i > 0 ? "修改成功" : "修改失败");

        statement.close();
        connection.close();

    }
}
