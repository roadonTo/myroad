package 面向对象编程.匿名内部类;

/**
 * 匿名内部类的简单使用
 */
public class AnonymousDetail {
    public static void main(String[] args) {

        Outer05 outer05 = new Outer05();
        outer05.f1();

    }
}


class Outer05 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        Person p = new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法");
            }
        };
        p.hi();//动态绑定，真实的运行类型是 Outer05

        //也可以直接调用,因为匿名内部类在底层本身也是返回对象
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写hi方法，哈哈");
            }
        }.hi();
    }
}

class Person {
    public void hi() {
        System.out.println("person hi()");
    }
}





