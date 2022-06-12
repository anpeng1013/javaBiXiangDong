package day10;

import java.util.Date;
/*
Date类对象是中的long类型的fastTime属性记录了从1970年1月1日08:00:00至今的毫秒数，
     用创建无参构造函数时，默认使用当前的毫秒数建立对象
     也可以使用有参构造函数，参数需要是long型，是Date对象中的fastTime等于该参数。
 */
public class DateDemo {
    public static void main(String[] args) throws InterruptedException {
        long time=System.currentTimeMillis();
        System.out.println(new Date(0));//直接打印Date对象的字符串表现形式是
        // Thu Jan 01 08:00:00 CST 1970 -->星期 月份 日期 时:分:秒 时区 年份

        System.out.println("time = " + time);

        Thread.sleep(10000);//延迟10秒

        Date olddate=new Date(time);
        System.out.println("old date = " + olddate);//date = Wed Apr 14 10:49:58 CST 2021
        System.out.println(olddate.getYear());//获取年份，返回一个值，该值是由此Date对象表示的时间点开始
        // 的年份中减去1900的结果，注意计算机中的起始时间点是从1970-1-1开始的。

        System.out.println("new date = " + new Date());//两个对象的时间差为10秒。

    }
}
