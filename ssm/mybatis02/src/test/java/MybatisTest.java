import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import road.mapper.UserMapper;
import road.pojo.User;
import road.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getByName("sakura");
        System.out.println(user);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser1("sakura", "123");
        System.out.println(user);
    }

    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser2("sakura", "123");
        System.out.println(user);
    }

    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "333", "222", 13, "男", "1234@dd.com");
        int i = mapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getAllUser();
        System.out.println(userList);

    }

    @Test
    public void test6(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String email = mapper.getOneName("sakura");
        System.out.println(email);

    }

    @Test
    public void test7(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> objectMap = mapper.getUserColumns(2);
        System.out.println(objectMap);
    }

    @Test
    public void test8(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> someUsersColumns = mapper.getSomeUsersColumns();
        System.out.println(someUsersColumns);
    }

    @Test
    public void test9(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> mapList = mapper.getUserLike("kang");
        System.out.println(mapList);

    }

    @Test
    public void test10(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUserById("4, 5");
        System.out.println(i);
    }

    @Test
    public void test11(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "333", "222", 13, "男", "1234@dd.com");
        mapper.insertOneUser(user); //执行insert语句 会将自增生成的id  放回到user中，
        // 上面new的时候id为null，但下面输出的时候 就有id值了
        System.out.println(user);
    }


}

