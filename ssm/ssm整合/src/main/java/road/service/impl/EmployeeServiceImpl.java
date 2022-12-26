package road.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import road.mapper.EmployeeMapper;
import road.pojo.Employee;
import road.service.EmployeeService;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }


    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 4);
        //查询所有的员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo(list, 5);
        return page;
    }
}
