package 面向对象编程.匿名内部类;


/**
 * 有一个铃声接口Bell，里面有个ring方法
 * 有一个手机类Cellphone，具有闹钟功能alarmClock，参数是Bell类型
 * 需求：测试手机类的闹钟功能，通过匿名内部类（对象）作为参数，打印：懒猪起床了，
 * 再传入另一个匿名内部类（对象），打印：小伙伴上课了
 */
public class InnerClassExercise02 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        /*
            下面方法 参数里面其实是这样的，编译类型是左边的Bell，运行类型就是看右边的
            Bell bell = new Bell() {
                @Override
                public void ring() {
                    System.out.println("懒猪起床了！");
                }
            }
         */
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了！");
            }
        });
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了!");
            }
        });
        //  通过上面这两个匿名内部类输出不同的语句可以看出 很灵活
    }
}


interface Bell { //铃声接口
    void ring();
}


class Cellphone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}



