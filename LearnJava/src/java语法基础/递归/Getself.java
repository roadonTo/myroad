package java语法基础.递归;

public class Getself {

    public static void main(String[] args) {
        int time = 10;
        BB bb = new BB();
        int num = bb.getNum(time);
        System.out.println("最初一共有：" + num + "个桃子");

    }

}


//猴子吃桃子问题：有一堆桃，猴子每天吃其中的一半然后再多吃一个，
//到第10天时，发现只剩1个桃子了。问 最初一共有多少个桃子
class BB{
    public int getNum(int n) { //n是天数,逆推   假设一共是十天
        if (n == 1) {
            return 1;
        } else {
            return (getNum(n-1) + 1 ) * 2 ; //getNum(n-1) 表示第九天的桃子
        }
    }
}