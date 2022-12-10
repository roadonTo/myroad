package road;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import road.mapper.DeptMapper;
import road.mapper.EmpMapper;
import road.pojo.Dept;
import road.pojo.Emp;
import road.utils.SqlSessionUtil;

import java.util.List;

public class MybatisTest {

    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById1(2);
        System.out.println(emp);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById2(3);
        System.out.println(emp);
    }

    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById3(3);
        System.out.println(emp);
    }

    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById4(1);
        System.out.println(emp);
    }

    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getDeptByStepOne(1);
        System.out.println(emp);
    }


    @Test
    public void test6(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptAndEmpList = mapper.getDeptAndEmp(3);
        deptAndEmpList.forEach(System.out::println);
    }














}
