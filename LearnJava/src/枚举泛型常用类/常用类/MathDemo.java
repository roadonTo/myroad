package 枚举泛型常用类.常用类;

/*
    Math类的常用方法
 */
public class MathDemo {
    public static void main(String[] args) {
        //public static int abs​(int a)：返回参数的绝对值
        System.out.println(Math.abs(88));
        System.out.println(Math.abs(-88));
        System.out.println("--------");


        //public static int round​(float a)：按照四舍五入返回最接近参数的int
        System.out.println(Math.round(12.34F));
        System.out.println(Math.round(12.56F));
        System.out.println("--------");

        //public static int max​(int a,int b)：返回两个int值中的较大值
        System.out.println(Math.max(66, 88));
        System.out.println("--------");

        //public static int min​(int a,int b)：返回两个int值中的较小值(自学)

        //public static double pow​(double a,double b)：返回a的b次幂的值
        System.out.println(Math.pow(2.0, 3.0));
        System.out.println("--------");

        //public static double random​()：返回值为double的正值，[0.0,1.0)
//        System.out.println(Math.random());
        System.out.println((int) (Math.random() * 100) + 1);
    }
}
