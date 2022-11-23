package IO流.处理流用到的修饰器设计模式;

/**
 * 处理流用到的 修饰器设计模式
 */
public abstract class Reader_ {

    public void readFile(){};

    public void readString(){};

    //后面改进 可以用对象的动态绑定机制  用一个方法就可以，绑定到对应的实现子类即可
}
