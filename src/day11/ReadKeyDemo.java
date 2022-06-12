package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadKeyDemo {
    public static void main(String[] args) throws IOException {
//        readKey();
//        showLineSeparator();
//        readKey_1();
        readKey_2();
    }

    private static void readKey_2() throws IOException {
        /**
         * 获取用户键盘录入的数据
         * 并将数据变成大写显示在控制台上
         * 如果用户输入的是over，结束键盘录入。
         *
         * 思路：
         * 1、因为键盘录入只读取一个字节，要判断是否为over，需要将读取到的字节拼成字符串
         * 2、那就需要一个容器。StringBuilder.
         * 3、在用户回车之前将录入的数据变成字符串判断即可
         */

        //创建容器
        StringBuilder stringBuilder=new StringBuilder();
        //获取键盘读取流
        InputStream inputStream=System.in;
        //定义变量记录读取到的字节，并循环获取
        int ch=0;
        while ((ch=inputStream.read())!=-1){
            //在存储之前需要判断是否是换行标记，因为换行标记不存储。
            if(ch=='\r')
                continue;
            if(ch=='\n'){
                String temp=stringBuilder.toString();
                if ("over".equals(temp))
                    break;
                System.out.println(temp.toUpperCase());
                stringBuilder.delete(0,stringBuilder.length());
            }
            else
                //将读取到的字节存储到StringBuilder中
                stringBuilder.append((char)ch);
        }

    }

    private static void readKey_1() throws IOException {
        InputStream inputStream = System.in;
        int ch = 0;
        while ((ch = inputStream.read()) != -1) {
            //在这种方式下，键盘输入无法结束。
            System.out.println(ch);
        }

    }

    private static void showLineSeparator() {
        Properties lineSeparator = System.getProperties();
        char[] chs = lineSeparator.getProperty("line.separator").toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i] + 0);
        }

    }

    private static void readKey() throws IOException {
        InputStream inputStream = System.in;//默认的输入流，不需要关闭。

        int[] ch=new int[3];
        //阻塞式等待输入
        //测试时，只输入一个英文字母，
        for (int i = 0; i < 3; i++) {
            ch[i]=inputStream.read();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(ch[i]);
        }

    }
}
