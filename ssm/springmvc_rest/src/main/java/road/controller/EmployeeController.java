package road.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import road.dao.EmployeeDao;
import road.pojo.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * 查询所有的员工信息-->/employee-->get
 * 跳转到添加页面-->/to/add-->get
 * 新增员工信息-->/employee-->post
 * 跳转到修改页面-->/employee/1-->get
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;


    /**
     * 查看所有员工
     *
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    /**
     * 新增员工信息
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /**
     * to update
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id); //查出要修改员工的信息
        model.addAttribute("employee", employee); //把信息放到请求域中
        return "employee_update"; //跳转到修改页面
    }

    /**
     * 修改员工信息
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }


    /**
     * 删除员工信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee"; //这个没有写
    }


}
