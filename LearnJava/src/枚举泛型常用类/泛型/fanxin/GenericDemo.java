package 枚举泛型常用类.泛型.fanxin;

/*
    测试类

    ----放这里记一下 ----
        类型通配符：<?>
        List<?>：表示元素类型未知的List，它的元素可以匹配任何的类型
        这种带通配符的List仅表示它是各种泛型List的父类，并不能把元素添加到其中

    类型通配符上限：<? extends 类型>
        List<? extends Number>：它表示的类型是Number或者其子类型

    类型通配符下限：<? super 类型>
        List<? super Number>：它表示的类型是Number或者其父类型
 */
public class GenericDemo {
    public static void main(String[] args) {
        Generic<String> g1 = new GenericImpl<String>();
        g1.show("林青霞");

        Generic<Integer> g2 = new GenericImpl<Integer>();
        g2.show(30);
    }
}
