package java8新特性;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 */
public class StreamAPITest1 {

    //1. 筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        //filter(Predicate p)——接收Lambda，从流中选出某些元素
        stream.filter(employee -> employee.getSalary() > 500).forEach(System.out::println);
        System.out.println();
        //limit(n)——截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //skip(n)——跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流 即啥也没有
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
        //distinct()——筛选，通过流所生成元素的hashCode()和equals() 去除重复元素
        Employee employee = new Employee(1111, "www", 25, 495.12);
        list.add(employee);
        list.add(employee);
        list.add(employee);
        list.stream().distinct().forEach(System.out::println);

    }

    //2.映射
    @Test
    public void test2() {
        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

    }


    //3.排序
    @Test
    public void test3() {
        //sorted() 自然排序
        //sorted(Comparator com) 定制排序
        List<Integer> list = Arrays.asList(12, 35, 64, 43, 24, 26);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().sorted((e1, e2) -> Integer.compare(e1, e2)).forEach(System.out::println);

    }


}
