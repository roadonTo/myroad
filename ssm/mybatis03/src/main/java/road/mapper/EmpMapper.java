package road.mapper;

import org.apache.ibatis.annotations.Param;
import road.pojo.Emp;

public interface EmpMapper {

    /**
     * 处理字段名和属性名不一致的情况
     * @param empId
     * @return
     */
    Emp getEmpById1(@Param("empId") Integer empId);

    Emp getEmpById2(@Param("empId") Integer empId);

    /**
     * 处理多对一的映射关系
     * @param empId
     * @return
     */
    Emp getEmpById3(@Param("empId") Integer empId);

    Emp getEmpById4(@Param("empId") Integer empId);

    Emp getDeptByStepOne(@Param("empId") Integer empId);


}
