package com.road;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbcUtils {

    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from fruit where fid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 2);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println(resultSet.getString("fname") + "的数量为：" + resultSet.getInt(4));
        }

        JdbcUtils.release(connection, statement, resultSet);

    }
}
