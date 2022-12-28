package java8新特性;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供用于测试的数据
 */
public class EmployeeData {

    public static List<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "aaa", 34, 455.12));
        list.add(new Employee(1002, "bbb", 13, 1007.21));
        list.add(new Employee(1003, "ccc", 47, 275.34));
        list.add(new Employee(1004, "ddd", 25, 495.12));
        list.add(new Employee(1005, "eee", 61, 905.02));
        return list;
    }


}
