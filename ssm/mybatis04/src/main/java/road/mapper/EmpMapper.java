package road.mapper;

import org.apache.ibatis.annotations.Param;
import road.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> getEmps(@Param("empId") Integer empId, @Param("empName") String empName, @Param("age") Integer age);

    List<Emp> getEmps2(@Param("empId") Integer empId, @Param("empName") String empName, @Param("age") Integer age);

    void insertEmps(@Param("emps") List<Emp> emps);

    Emp getOneEmp(@Param("empId") Integer empId);



}
