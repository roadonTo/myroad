package road;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import road.mapper.EmpMapper;
import road.pojo.Emp;
import road.utils.SqlSessionUtil;

import java.util.Arrays;
import java.util.List;

public class MybatisTest {

    @Test
    public void test1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.getEmps(null, "张三", null);
        System.out.println(emps);

    }

    @Test
    public void test2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.getEmps2(2, null, null);
        System.out.println(emps);

    }

    @Test
    public void test3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp(null, "kangkang", 18, "男");
        Emp emp2 = new Emp(null, "kangkang", 18, "男");
        Emp emp3 = new Emp(null, "kangkang", 18, "男");
        List<Emp> empList = Arrays.asList(emp1, emp2, emp3);
        mapper.insertEmps(empList);
        System.out.println("插入成功");

    }

    @Test
    public void test4() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp oneEmp = mapper.getOneEmp(1);
        System.out.println(oneEmp);

    }


}
