package road.mapper;

import org.apache.ibatis.annotations.Param;
import road.pojo.Dept;

import java.util.List;

public interface DeptMapper {

    Dept getDeptByStepTwo(@Param("deptId") Integer deptId);

    List<Dept> getDeptAndEmp(@Param("deptId") Integer deptId); //测试一对多

}
