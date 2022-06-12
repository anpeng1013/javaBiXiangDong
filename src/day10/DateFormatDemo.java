package day10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
DateFormat 采用饿汉式的单例模式。
Date类对象可以对Date对象进行具体风格的格式化字符串输出。

对日期对象进行指定格式化
    将日期对象-->日期格式的字符串
        使用的DateFormat类中的format方法。
        将日期对象自定义格式化字符串，用DateFormat的子类SimpleDateFormat。
    将日期格式的字符串-->日期对象。
        使用的是DateFormat类中的parse方法，该方法会抛出ParseException
 */

public class DateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //DateToString();
        StringToDate();
    }

    private static void StringToDate() throws ParseException {
        String str_date="2021-4-16";
        String str_date1="2021年4月15日";
        String str_date2="2021---4---14";

        DateFormat dateFormat=DateFormat.getDateInstance();
        DateFormat dateFormat1=DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat dateFormat2=new SimpleDateFormat("yyyy---MM---dd");

        Date date=dateFormat.parse(str_date);
        Date date1=dateFormat1.parse(str_date1);
        Date date2=dateFormat2.parse(str_date2);

        System.out.println("date = " + date);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
    }

    private static void DateToString() {
        Date date=new Date();
        //获取日期格式对象。FULL LONG等可以指定风格。
        DateFormat dateFormat=DateFormat.getDateInstance();
        DateFormat dateFormat1=DateFormat.getDateInstance(DateFormat.DEFAULT);
        DateFormat dateFormat2=DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dateFormat3=DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat dateFormat4=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);

        System.out.println("dateFormat = " + dateFormat.format(date));
        System.out.println("dateFormat1 = " + dateFormat1.format(date));
        System.out.println("dateFormat2 = " + dateFormat2.format(date));
        System.out.println("dateFormat3 = " + dateFormat3.format(date));
        System.out.println("dateFormat4 = " + dateFormat4.format(date));

        //自定义风格的日期格式字符串。
        dateFormat =new SimpleDateFormat("yyyy--MM--dd");
        System.out.println("dateFormat = " + dateFormat.format(date));
    }
}
