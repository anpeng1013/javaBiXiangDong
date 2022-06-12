package day03;

public class SwitchTest {
    public static void main(String[] args){
        /*
        根据用户输入的数据对应的输出星期
         */
        int week=8;
        switch (week){
            case 1:
                System.out.println(week+"对应的是星期一");
                break;
            case 2:
                System.out.println(week+"对应的是星期二");
                break;
            case 3:
                System.out.println(week+"对应的是星期三");
                break;
            case 4:
                System.out.println(week+"对应的是星期四");
                break;
            case 5:
                System.out.println(week+"对应的是星期五");
                break;
            case 6:
                System.out.println(week+"对应的是星期六");
                break;
            case 7:
                System.out.println(week+"对应的是星期日");
                break;
                default:
                    System.out.println(week+"没有对应的星期");
        }

        /*
        switch的实例
         */
        int month=5;
        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println(month+"月对应的是春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(month+"月对应的是夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(month+"月对应的是秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println(month+"月对应的是冬季");
                break;
                default:
                    System.out.println(month+"月没有对应的季节！");
        }
    }
}
