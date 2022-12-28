package 枚举泛型常用类.常用类;

/*
    一：
    静态方法获取对象：
        public static Integer valueOf​(int i)：返回表示指定的 int 值的 Integer 实例
        public static Integer valueOf​(String s)：返回一个保存指定值的 Integer 对象 String

    二：
    int 和 Integer 这种之间转换 可以自动拆装箱（jdk1.5之后）
    装箱：把基本数据类型转换为对应的包装类类型
    拆箱：把包装类类型转换为对应的基本数据类型

 */
public class IntegerDemo {
    public static void main(String[] args) {
        //public Integer(int value)：根据 int 值创建 Integer 对象(过时)
        // Integer i1 = new Integer(100); //这种方式是 过时的，不要用


        //public static Integer valueOf​(int i)：返回表示指定的 int 值的 Integer 实例
        Integer i3 = Integer.valueOf(100);
        System.out.println(i3);

        //public static Integer valueOf​(String s)：返回一个保存指定值的 Integer 对象 String
        Integer i4 = Integer.valueOf("100");
        System.out.println(i4);


        //---------------

        //装箱：把基本数据类型转换为对应的包装类类型
        Integer i = Integer.valueOf(100); //这种是手动的装箱
        Integer ii = 100; //自动装箱 ，相当于 Integer.valueOf(100);
        ii += 200;  //ii = ii + 200;  ii + 200 自动拆箱；ii = ii + 200; 是自动装箱

        System.out.println(i + "," + ii);
    }
}
