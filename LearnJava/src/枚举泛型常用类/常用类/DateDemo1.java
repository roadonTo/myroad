package 枚举泛型常用类.常用类;

import java.util.Date;
/*
    public Date()：分配一个 Date对象，并初始化，以便它代表它被分配的时间，精确到毫秒
    public Date(long date)：分配一个 Date对象，并将其初始化为表示从标准基准时间起指定的毫秒数

    public long getTime():获取的是日期对象从1970年1月1日 00:00:00到现在的毫秒值(这个意思就是 显示的就是当前时间)
    public void setTime(long time):设置时间，给的是毫秒值
 */
public class DateDemo1 {
    public static void main(String[] args) {
        //public Date()：分配一个 Date对象，并初始化，以便它代表它被分配的时间，精确到毫秒
        Date d1 = new Date();
        System.out.println(d1); //Wed Dec 22 17:02:02 CST 2021

        //public Date(long date)：分配一个 Date对象，并将其初始化为表示从标准基准时间起指定的毫秒数
        long date = 1000*60*60;
        Date d2 = new Date(date);
        System.out.println(d2); //Thu Jan 01 09:00:00 CST 1970

        Date d = new Date();
        d.getTime();
        System.out.println(d);
        long time = System.currentTimeMillis();
        d.setTime(time);
        System.out.println(d);
    }
}
