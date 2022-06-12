package day11;

import java.io.*;

public class TransStreamTest {
    public static void main(String[] args) throws IOException {
        //需求：将键盘录入的数据写到一个文件当中。
//        showConsoleToFile();

        //需求：将一个文本内容显示在控制台上。
//        showFileToConsole();

        //需求：将一个文本文件中的内容复制到另一文件中。
//        showFileToFile();
        //需求：将一个中文字符串数据按照指定的编码表写入到一个文本文件中。
//        writeText();
        //需求：将一个文本文件数据按照指定的编码表读出。
        readText();
    }

    private static void readText() throws IOException {
        FileReader fileReader=new FileReader("utf_8.txt");//IDEA默认编码表为utf-8
        char[] buffer=new char[10];
        int length =fileReader.read(buffer);
        String string=new String(buffer,0,length);
        System.out.println(string);//你好
        fileReader.close();

        InputStreamReader inputStreamReader=new InputStreamReader(
                new FileInputStream("utf_8.txt"),"gbk" );
        length=inputStreamReader.read(buffer);
        string=new String(buffer,0,length);
        System.out.println(string);//浣犲ソ
        inputStreamReader.close();
    }

    private static void writeText() throws IOException  {
        /**
         * gbk:国标汉字编码表，只对中文进行编码，一个汉字占两个字节
         * utf-8:国际统一编码表，对所有语言进行编码，1-6字节表示一个语言文字，其中一个汉字占三个字节。
         */
        FileWriter fileWriter = new FileWriter("utf_8.txt");//IDEA默认的编码表。
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(
                new FileOutputStream("gbk.txt"),"gbk");//指定编码表。
        /**
         * 这两句代码的功能是等同的。
         * FileWriter：其实就是转换流指定了本机默认码表的表现。而且这个转换流的子类对象，可以方便操作文本文件。
         *              简单说：操作文件的字节流+本机默认的编码表
         *              这是按照默认编码表操作文件的便捷类。
         * 如果操作文本文件需要明确具体的编码表。FileWriter就不行了，必须使用转换流。
         */
        outputStreamWriter.write("你好");//4个字节
        fileWriter.write("你好");//6个字节
        fileWriter.close();
        outputStreamWriter.close();
    }

    private static void showFileToFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    private static void showFileToConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    private static void showConsoleToFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt")));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if ("over".equals(line))
                break;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }
}
