package 枚举泛型常用类.常用类;

import java.util.Calendar;

/*
    Calendar 为特定瞬间与一组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法

    Calendar 提供了一个类方法 getInstance 用于获取这种类型的一般有用的对象，该方法返回一个 Calendar 对象，
    其日历字段已使用当前日期和时间初始化：Calendar rightNow = Calendar.getInstance();


    public abstract void add​(int field, int amount):根据日历的规则，将指定的时间量添加或减去给定的日历字段
    public final void set​(int year,int month,int date):设置当前日历的年月日

 */
public class CalendarDemo {
    public static void main(String[] args) {
        //日历字段已使用当前日期和时间初始化
        Calendar c = Calendar.getInstance();

//        System.out.println(c);

        //public int get​(int field)
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);

        //这里month加1 是因为 calendar中月份的取值是从0开始取到11结束的
        System.out.println(year + "年" + month + "月" + date + "日");


        //----------------


//        public abstract void add​(int field, int amount):根据日历的规则，将指定的时间量添加或减去给定的日历字段
//        需求1:3年前的今天
//        c.add(Calendar.YEAR,-3);
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH) + 1;
//        date = c.get(Calendar.DATE);
//        System.out.println(year + "年" + month + "月" + date + "日");
//        需求2:10年后的10天前
//        c.add(Calendar.YEAR,10);
//        c.add(Calendar.DATE,-10);
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH) + 1;
//        date = c.get(Calendar.DATE);
//        System.out.println(year + "年" + month + "月" + date + "日");
//
//        public final void set​(int year,int month,int date):设置当前日历的年月日
//        c.set(2050,10,10);
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH) + 1;
//        date = c.get(Calendar.DATE);
//        System.out.println(year + "年" + month + "月" + date + "日");
    }
}
