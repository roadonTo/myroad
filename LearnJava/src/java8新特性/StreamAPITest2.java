package java8新特性;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 测试stream的终止操作
 */
public class StreamAPITest2 {

    /*
        allMatch(Predicate p)---检查是否匹配所有元素
        anyMatch(Predicate p)---检查是否至少匹配一个元素
        noneMatch(Predicate p)---检查是否没有匹配的元素
        findFirst---返回第一个元素
        findAny---返回当前流中的任意元素
        count---返回流中元素的总个数
        max(Comparator c)---返回流中最大值
        min(Comparator c)---返回流中最小值
        forEach(Consumer c)---内部迭代
     */


    //1.匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

        long count = employees.stream().filter(e -> e.getSalary() > 300).count();
        System.out.println(count);

    }


    //2.归约
    //reduce(T identity, BinaryOperator)---可以将流中元素反复结合起来，得到一个值，返回T
    //reduce(BinaryOperator)---可以将流中元素反复结合起来，得到一个值，返回Optional<T>
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1, 3, 3, 4, 6, 7, 6);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

    }


    //3.收集
    //collect(Collector c)---将流转换为其他形式，接收一个Collector接口的实现，
    //里面传入 Collectors拥有的方法 例如 toList 转成list集合，toSet 转成set集合
    @Test
    public void test3(){
        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> employeeList = list.stream().filter(e -> e.getAge() > 15).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

    }


}
