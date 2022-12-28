package 枚举泛型常用类.泛型;

/**
 * 泛型的使用
 * 泛型类和泛型方法
 *
 * @param <T>
 */
public class ObjectTool<T> { //泛型类

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public <T> void show(T t) { //泛型方法
        System.out.println(t);
    }

    public static void main(String[] args) {
        //创建对象并指定元素类型
        ObjectTool<String> objectTool = new ObjectTool<>();
        objectTool.setObj("hhh");
        System.out.println(objectTool.getObj());

        objectTool.show(4); //调用方法，传入的参数是什么类型，返回值就是什么类型
        objectTool.show("hello");
    }

}
