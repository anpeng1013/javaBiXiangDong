package day10;

import java.util.Calendar;

/*
由于Date类中的方法不够国际化，被Calendar类取代。
Calendar类也使用了饿汉式的单例模式。
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        showCalendar(calendar);

        //演示Calendar类中的set方法
        calendar.set(2021,3,15);////月份从0开始算
        showCalendar(calendar);

        //演示Calendar类中的add方法。
        calendar.add(Calendar.DAY_OF_MONTH,12);
        showCalendar(calendar);
    }

    private static void showCalendar(Calendar calendar) {
        //演示Calendar类中的get方法。
        System.out.println(calendar);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;//月份从0开始算。
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int week = calendar.get(Calendar.DAY_OF_WEEK);//西方国家中每周的第一天是周日
        System.out.println(year + "年" + month + "月" + day + "日 "+getWeek(week));

    }

    private static String getWeek(int week) {
        String[] weeks={"","星期日","星期一","星期二",
                "星期三","星期四","星期五","星期六"};
        return weeks[week];
    }
}
