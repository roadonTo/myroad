package 枚举泛型常用类.常用类;

/*
    StringBuilder构造方法：
        public StringBuilder()：创建一个空白可变字符串对象，不含有任何内容
        public StringBuilder(String str)：根据字符串的内容，来创建可变字符串对象

    StringBuilder 的添加和反转方法
        public StringBuilder append(任意类型)：添加数据，并返回对象本身
        public StringBuilder reverse()：返回相反的字符序列

    StringBuilder 转换为 String
        public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String
    String 转换为 StringBuilder
        public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder

 */
public class StringBuilderDemo1 {
    public static void main(String[] args) {
        //public StringBuilder()：创建一个空白可变字符串对象，不含有任何内容
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);
        System.out.println("sb.length():" + sb.length());

        //public StringBuilder(String str)：根据字符串的内容，来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println("sb2:" + sb2);
        System.out.println("sb2.length():" + sb2.length());


        //链式编程
        sb.append("hello").append("world").append("java").append(100);
        System.out.println("sb:" + sb);

        //public StringBuilder reverse()：返回相反的字符序列
        sb.reverse();
        System.out.println("sb:" + sb);


        //StringBuilder 转换为 String
        StringBuilder sb1 = new StringBuilder();
        sb1.append("hello");
        //String s = sb1; //这个是错误的做法
        //public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String
        String s = sb1.toString();
        System.out.println(s);


        //String 转换为 StringBuilder
        String s1 = "hello";
        //StringBuilder sb = s1; //这个是错误的做法
        //public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder
        StringBuilder sb3 = new StringBuilder(s1);
        System.out.println(sb3);
    }
}
