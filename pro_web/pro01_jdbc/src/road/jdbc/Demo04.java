package road.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.利用驱动管理器连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruit?useSSL=false&useUnicode=true&characterEncoding=utf-8", "root", "root");

        String sql = "delete from fruit where fid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);

        int i = statement.executeUpdate();
        System.out.println(i > 0 ? "删除成功" : "删除失败");

        statement.close();
        connection.close();

    }
}
