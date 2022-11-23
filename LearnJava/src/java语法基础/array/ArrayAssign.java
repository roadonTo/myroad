package java语法基础.array;

/**
 * 数组的赋值机制
 * 从大的方面讲 其实都是值传递，只不过引用类型的值 放的是指向堆的地址（真实的值 是放在堆里面），所以引用类型传的值其实就是把这个堆的地址传过去了；
 * 而基本类型的值就存在栈里面，所以相当于是把这个值 复制了一份过去，这两个值只是字面上相等 其实并没有什么关联关系了。
 * 这个有张jvm里面示意图的  可以自己画着理解下
 */
public class ArrayAssign {

    public static void main(String[] args) {

        //1.基本类型赋值 传递的是值
        int a1 = 10;
        int a2 = a1;
        a2 = 90;    //改变a2的值 对a1没有影响
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);

        //2.引用类型赋值 传递的是地址   数组是引用类型
        int[] arr1 = {3,5,8};
        int[] arr2 = arr1;
        arr2[0] = 333;  //改变arr2的第一个元素，结果arr1的第一个元素也跟着变了

        for(int i = 0; i < arr1.length; i++){
            System.out.println("arr1 = " + arr1[i]);
        }



    }

}
