package java语法基础.array;

/**
 * 这都是基础到不能再基础的例子了
 */
public class Example1 {

//    static int sum; //这里的sum是全局变量 Java会自动初始化，但如果写在main方法里面 就是局部变量 必须初始化后才能使用

    public static void main(String[] args) {

        /**
         * 1.题目是  往一个char数组里 放入‘A’到 ‘Z’的字母 然后输出，已知‘A’ + 1 = ‘B’
         */
        char[] chars = new char[26];

        for (int i = 0; i < 26; i++) {
            //这里要注意的是 有一个类型转换顺序：char -> int -> double, float -> double
            //所以‘A’+i 首先是把‘A’自动转成int类型再相加 然后根据规则再给出对应的char值，但是只是在运算（加 等于）的时候会有自动类型转换
            //实际上i还是int类型，所以必须得强转 从高到低 从int -> char
            chars[i] = (char) ('A' + i);
            System.out.print(chars[i] + " ");
        }

        System.out.println();
        System.out.println("--------------");


        /**
         * 2.找出数组中最大的元素以及它的下标
         */
        int[] arr1 = {3, 45, -15, 138, 13, 97};

        //用到了一个思想：假定第一个元素为最大值，下标就是0 , 然后跟后面元素比较
        int max = 3;
        int maxIndex = 0;

        for (int i = 1; i < arr1.length; i++) {
            if (max < arr1[i]) {
                max = arr1[i];
                maxIndex = i;
            }
        }

        System.out.println("max = " + max + "," + "maxIndex = " + maxIndex);

        System.out.println();
        System.out.println("--------------");


        /**
         * 3.请 求出一个数组的和 与平均值
         */
        int[] arr2 = arr1;//用第二题的数组
        double sum = 0;
        double avg = 0.0;

        for (int i = 0; i < arr2.length; i++) {
            sum = sum + arr2[i];
        }

        avg = sum / arr2.length;
        System.out.println("sum = " + sum + "," + "avg = " + avg);


    }
}
