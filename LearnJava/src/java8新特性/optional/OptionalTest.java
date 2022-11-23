package java8新特性.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * 使用时 Optional有一系列方法可以掉，查资料看
 * 主要记住： Optional作为一个容器 装入你想要操作的对象，
 * 然后通过调用Optional的方法， 可以最大化减少发生空指针异常
 */
public class OptionalTest {

/*
Optional.of(T t): 创建一个Optional 实例，t必须非空；
Optional.empty(): 创建一个空的Optional实例
Optional.ofNullable(T t): t可以为null
 */

    @Test
    public void test1(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
    }


}
