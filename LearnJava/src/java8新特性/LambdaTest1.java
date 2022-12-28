package java8新特性;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 1. Lambda表达式的使用：（分为六种情况介绍）
 * <p>
 * 2. lambda表达式的本质：作为函数式接口的实例
 * （对于接口的要求 接口中只有一个方法，如果有两个方法 就不能这么用了）
 * <p>
 * 3. 如果一个接口中 只声明了一个抽象方法，则此接口就称为函数式接口
 * <p>
 * 当你需要创建一个函数式接口的对象时，就可以用Lambda表达式 来写！！！
 */
public class LambdaTest1 {

    //1. 无参无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hahaha");
            }
        };
        r1.run();
    }

    @Test
    public void test11() {
        Runnable r2 = () -> {
            System.out.println("hahaha");
        };
        r2.run();
    }


    //2.需要一个参数，但没有返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");
    }

    @Test
    public void test22() {
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("我也不知道");
    }


    //3.数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test222() {
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("我也不知道");
    }


    //4.Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test2222() {
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("我也不知道");
    }


    //5.Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test3() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));
        System.out.println("***************************");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(23, 18));
    }


    //6.当Lambda体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test4() {
        Comparator<Integer> com2 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(23, 18));
        System.out.println("*******************");

        Comparator<Integer> com3 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com3.compare(13, 15));

    }


}
