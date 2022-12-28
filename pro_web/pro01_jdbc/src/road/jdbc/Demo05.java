package road.jdbc;

import java.sql.*;
import java.util.ArrayList;

public class Demo05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.利用驱动管理器连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruit?useSSL=false&useUnicode=true&characterEncoding=utf-8", "root", "root");
        //3.编写sql语句
        String sql = "select * from fruit";
        //4.创建预处理命令对象
        PreparedStatement statement = connection.prepareStatement(sql);
        //5.执行查询,返回结果集
        ResultSet resultSet = statement.executeQuery();
        //6.解析结果集
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();
        while (resultSet.next()) {
            int fid = resultSet.getInt(1);
            String fname = resultSet.getString("fname");
            int price = resultSet.getInt(3);
            int fcount = resultSet.getInt(4);
            String remark = resultSet.getString(5);

            Fruit fruit = new Fruit(fid, fname, price, fcount, remark);
            fruitArrayList.add(fruit);

        }
        resultSet.close();
        statement.close();
        connection.close();

        fruitArrayList.forEach(System.out::println);

    }
}
