package road.mapper;

import org.springframework.stereotype.Repository;
import road.pojo.Employee;

import java.util.List;

@Repository
public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     *
     * @return
     */
    List<Employee> getAllEmployee();

}
