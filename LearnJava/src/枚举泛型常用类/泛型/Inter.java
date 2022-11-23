package 枚举泛型常用类.泛型;

/**
 * 泛型继承
 * 分为两种情况：
 * 子类明确，把继承的父类的T类型 换成明确的String类型，
 * 子类不明确，父子类都继续使用T类型
 * @param <T>
 */
public interface Inter<T> {
    public abstract void show(T t);
}
