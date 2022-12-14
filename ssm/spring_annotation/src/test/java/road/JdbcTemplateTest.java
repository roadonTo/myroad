package road;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import road.pojo.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //表示用spring的测试环境
@ContextConfiguration("classpath:spring-jdbc.xml") //表示可以用这个配置文件中的bean来注入；classpath 表示是类路径下的
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * jdbcTemplate增删改
     */
    @Test
    public void testUpdate(){
        String sql = "insert into user values(null, ?,?,?,?,?)";
        jdbcTemplate.update(sql,"nuonuo","123",20,"女","123@qq.cjom");

    }

    @Test
    public void testQueryUser(){
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), 1);
        System.out.println(user);

    }

    @Test
    public void testQueryAllUser(){
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        userList.forEach(System.out::println);
    }

    @Test
    public void testQueryCount(){
        String sql = "select count(*) from user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);

    }




}
