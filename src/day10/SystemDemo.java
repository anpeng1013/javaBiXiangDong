package day10;


import java.util.Properties;
import java.util.Set;

public class SystemDemo {
    public static void main(String[] args) {
        long l0=1618363965365l;
        long l1=System.currentTimeMillis();//获取当前时间的毫秒值
        System.out.println("l = " + (l1-l0));

        //获取系统的属性信息，并存储大Properties集合中
        showProperties();

        //unix的换行符是\n,而Windows的换行符是\r\n
//        System.out.println("hello-\n world");
//        System.out.println("hello-\r\n world");

    }

    private static void showProperties() {
        //获取系统的属性信息，并存储大Properties集合中
        /*
        Properties集合中存储的都是String类型的键和值
        最好使用它自己的存取方法来完成元素的操作
         */
        Properties properties=System.getProperties();
        Set<String> keySet=properties.stringPropertyNames();
        for (String name:keySet){
            String value=properties.getProperty(name);
            System.out.println(name+" :: "+value);
        }
    }
}
