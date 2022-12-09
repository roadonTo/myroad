package road.mapper;

import org.apache.ibatis.annotations.Param;
import road.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 如何获取参数
     */
    User getByName(String name); //通过一个参数获取实体

    User getUser1(String name, String pwd); //通过多个参数获取实体 mybatis默认方式

    User getUser2(@Param("name") String name, @Param("pwd") String pwd); //通过多个参数获取实体 注解方式

    int insertUser(User user); //参数是实体类型

    /**
     * 各种类型的查询
     */

    //User getByName(String name); //查询 返回一个实体类对象

    List<User> getAllUser(); //查询 返回一个list集合

    String getOneName(@Param("name") String name); //查询 返回一个字段

    Map<String, Object> getUserColumns(@Param("id") Integer id); //获取某个对象的 某几项数据(这里就比如获取密码，年龄，邮箱)

    List<Map<String, Object>> getSomeUsersColumns(); //获取多个对象的 某几项数据

    /**
     * 特殊sql  （模糊查询，批量删除，获取自增的主键）
     */
    List<Map<String, Object>> getUserLike(@Param("mohu") String mohu); //模糊查询 (你不知道有几个所以用map)

    int deleteUserById(@Param("ids")String ids); //批量删除

    void insertOneUser(User user); //获取自增的主键

}
