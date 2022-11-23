package 面向对象编程.可变参数;

public class Demo {

    public static void main(String[] args) {
        DD dd = new DD();
        int i = dd.kbcs(3, 5, 7, 1);
        System.out.println(i);

    }

}

// 测试可变参数的使用
class DD{
    public int kbcs(int... m){
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum+= m[i];
        }
        return sum;
    }
}
