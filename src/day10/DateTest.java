package day10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
练习：
"2012-3-17"到"2012-4-6"中间有多少天？
思路：
    两个日期对象相减，因为日期对象的毫秒值可以相减。
1、将日期格式的字符串转成Date对象。
2、将Date对象转成毫秒值。
3、两个毫秒值相减，再变成天数。
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        test();
    }

    private static void test() throws ParseException {
        String string_date="2012-3-17";
        String string_date1="2012-4-6";

        //1、将日期格式的字符串转成Date对象。
        DateFormat dateFormat=DateFormat.getDateInstance();
        dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=dateFormat.parse(string_date);
        Date date1=dateFormat.parse(string_date1);

        //2、将Date对象转成毫秒值。
        long time=date.getTime();
        long time1=date1.getTime();

        //3、两个毫秒值相减，再变成天数。
        long time2=Math.abs(time-time1);
        int day=getDay(time2);
        System.out.println(day);
    }

    private static int getDay(long time) {
        return (int)time/1000/60/60/24;
    }
}
