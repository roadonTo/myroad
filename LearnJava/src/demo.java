

public class demo {

    public static void main(String[] args) {
        DD dd = new DD();
        int i = dd.cbcs(3, 5, 7, 1);
        System.out.println(i);

    }

}


// 测试可变参数的使用
class DD {
    public int cbcs(int... m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
        return sum;
    }
}

// 判断一个数是奇数还是偶数
class AA {
    public boolean judgeNum(double t) {
        return t % 2 == 0 ? true : false;
    }
}


//猴子吃桃子问题：有一堆桃，猴子每天吃其中的一半然后再多吃一个，
//到第10天时，发现只剩1个桃子了。问 最初一共有多少个桃子
class BB {
    public int getNum(int n) { //n是天数,逆推   假设一共是十天
        if (n == 1) {
            return 1;
        } else {
            return (getNum(n - 1) + 1) * 2; //getNum(n-1) 表示第九天的桃子
        }
    }
}

// StringBuilder构建字符串
class CC {
    public void joinString() {
        StringBuilder builder = new StringBuilder();
        builder.append("qqq");
        builder.append(" rrr");
        builder.append(2);
        String s = builder.toString();
    }
}




















