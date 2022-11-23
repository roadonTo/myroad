package 枚举泛型常用类.泛型;

public class InterImpl<T> implements Inter<T> {

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
