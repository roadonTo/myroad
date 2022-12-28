import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDatasource {

    DruidPooledConnection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;


    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select * from user");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username")); //可以输出值，说明连上了数据库
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }


}
