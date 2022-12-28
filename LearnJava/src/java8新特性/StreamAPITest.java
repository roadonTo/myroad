package java8新特性;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest {

    //创建Stream方式一：通过集合
    @Test
    public void test1() {

        //因为是通过集合的，所以首先需要一个集合对象
        ArrayList<String> list = new ArrayList<>();
        //default Stream<E> stream() ; 返回一个顺序流
        Stream<String> stream = list.stream();
        //default Stream<E> parallelStream() ; 返回一个并行流
        Stream<String> parallelStream = list.parallelStream();

    }


    //创建Stream方式二：通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 3, 5, 2, 56, 13};
        //调用Arrays类的static <T> Stream<T> stream(T[] array) ;  返回一个流
        IntStream stream = Arrays.stream(arr);

    }


    //方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 4, 5, 6);

    }


}
