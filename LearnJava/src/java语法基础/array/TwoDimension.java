package java语法基础.array;

/**
 * 二维数组
 */
public class TwoDimension {

    public static void main(String[] args) {

        //1.一个有三个一维数组的二维数组，每个一维数组的元素的个数不一样
        /*
            i = 0 : 1个
            i = 1 : 2个
            i = 2 : 3个
        */
        int[][] arr = new int[3][]; //表示创建了一个二维数组 包含了三个元素 （也就是三个一维数组的地址 注意：此时三个一维数组还没有开辟空间）

        //这里的给每个一维数组开辟空间很重要，要理解
        for (int i = 0; i < arr.length; i++) {
            //给每个一维数组开空间 new
            //如果没有开空间，那么arr[i]就是null，
            arr[i] = new int[i + 1];

            //给每个一维数组的每个元素赋值
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
            }
        }

        //遍历二维数组输出
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        //2.杨辉三角
        //规律是 第一行一个数，第二行两个数，第三行三个数，
        // 每行的第一个和最后一个都为1，中间的规律为 arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
        int[][] arr1 = new int[8][];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new int[i + 1]; //第一个一维数组长度为1，后面的依次多1个   所以开辟空间就 i+1 就行了

            for (int j = 0; j < arr1[i].length; j++) {

                if (j == 0 || j == arr1[i].length - 1) {
                    arr1[i][j] = 1;
                } else {
                    arr1[i][j] = arr1[i - 1][j] + arr1[i - 1][j - 1];
                }
            }
        }

        System.out.println("输出杨辉三角:");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

    }
}
