package java语法基础.array;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        //n个元素的数组，第一趟时比较n-1次 把最大值放到最后面，第二趟时比较n-2次 （即最后一个最大的不用再参与比较了） 以此类推
        //代码：两层for循环，外层只是在控制比较的次数 每次排完了就可以少比较一个，内层控制比较大小后的交换
        int[] arr = {3, 14, 8, -6, 45, 28, 72, 19, -3};


        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0; //用于交换时 暂存值的媒介
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }

            System.out.print("\n第" + (i + 1) + "次循环 arr = ");
            for (int m = 0; m < arr.length; m++) {
                System.out.print(arr[m] + "\t");
            }
        }

    }
}
