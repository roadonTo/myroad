package 枚举泛型常用类.泛型.fanxin;

public class GenericImpl<T> implements Generic<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
