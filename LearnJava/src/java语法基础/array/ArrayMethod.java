package java语法基础.array;

/**
 * 数组常用到的一些操作
 */
public class ArrayMethod {

    public static void main(String[] args) {

        //1.数组拷贝，数据空间是独立的， 即改变数组值互相不会影响 没有关系
        int[] arr1 = {2, 4, 7, 9, 18};

        int[] arr2 = new int[arr1.length]; //用new 就是开辟了新的空间
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
            System.out.println("arr2 = " + arr2[i] + " ");
        }

        System.out.println("-----------------");


        //2.数组翻转
        // 第一种思路在原数组中把第一个元素和最后一个元素互换位置，
        // 第二种思路new一个新数组，把原数组逆序赋值给新数组 然后把原数组指向新数组， 原数组的地址因没有被引用而被垃圾回收，这样也就只是一个数组
        int[] arr3 = {3, 12, 6, 24, 8, 5, 7};

        System.out.println("这是第一种思路的反转：");
        for (int i = 0; i < arr3.length / 2; i++) {
            int temp = arr3[arr3.length - 1 - i];
            arr3[arr3.length - 1 - i] = arr3[i];
            arr3[i] = temp;
        }

        for (int t = 0; t < arr3.length; t++) {
            System.out.print(arr3[t] + " ");
        }

        System.out.println();
        System.out.println("这是第二种思路的反转：");
        System.out.println("因为第一种思路已经把原数组翻转了，然后第二种再翻回来，所以就是原数组的排列顺序 ");
        int[] arr4 = new int[arr3.length];

        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = arr3[arr3.length - 1 - i];
        }

        arr3 = arr4;  //把数组arr4的地址 给arr3，以便把arr3的地址给释放出去

        for (int t = 0; t < arr4.length; t++) {
            System.out.print(arr4[t] + " ");
        }

        System.out.println("-----------------");


        //3.数组扩容  因为数组长度是不可变的，new出来是多少就是多少
        //所以扩容的意思就是再new一个 新的长度的数组 操作完了后，把原本的数组指向这个新地址就行了


    }
}
