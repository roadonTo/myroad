package java语法基础.array;

/**
 * 数组使用的七个小细节
 */
public class ArrayDetail {

    public static void main(String[] args) {

        //1.数组是多个同类型数据的组合
        double[] arr2 = {1.1, 2.2, 60, 78};//int -> double  低精度转高 这个是可以放数组里的 反过来不行

        //2.数组中的元素可以是任何数据类型，包括基本类型和引用类型，但是不能混用
        String[] arr3 = {"jack", "北京", "kangkang"};

        //3.数组创建后，如果没有赋值 ，有默认值
        //int、short、byte、long  0 ,
        //float  0.0 , double  0.0 ,  char  \u0000
        //boolean  false ,  String  null


        //4.使用数组的步骤：1.声明数组并开辟空间 2.给数组各个元素赋值 3.使用数组

        //5.数组的下标是从0开始的。（因为听说 老外的家都有地下室 它们把地下室就称为0层，java是老外发明的嘛）

        //6.数组下标必须在指定范围内使用，否则报 下标越界异常 ArrayIndexOutOfBoundsException

        //7.数组是引用类型，数组型数据属于对象（Object）


    }
}
