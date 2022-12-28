package road.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.利用驱动管理器连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruit?useSSL=false&useUnicode=true&characterEncoding=utf-8", "root", "root");
        //3.编写sql语句
        String sql = "insert into fruit values(0,?,?,?,?)"; //主键设置的自动递增，填个零或者不填都行
        //4.创建预处理命令对象
        PreparedStatement statement = connection.prepareStatement(sql);
        //5.填充参数
        statement.setString(1, "西瓜");
        statement.setInt(2, 30);
        statement.setInt(3, 11);
        statement.setString(4, "谢谢你");
        //6.执行更新（增删改），返回影响行数
        int count = statement.executeUpdate();
        System.out.println(count > 0 ? "添加成功" : "添加失败");
        //7.关闭连接
        statement.close();
        connection.close();


    }

}






