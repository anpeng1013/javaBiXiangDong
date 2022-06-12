package day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BytesStreamDemo {
    public static void main(String[] args) throws IOException {
        demo_write();
        demo_read();
    }
/*
不能用字符流对象操作媒体文件。
 */
    private static void demo_read() throws IOException {
        //1、创建一个读取流对象，与指定文件关联。
        FileInputStream fileInputStream=new FileInputStream("byteDemo.txt");

        //2、读取数据
        int ch = 0;
        while ((ch=fileInputStream.read())!=-1){
            System.out.print((char)ch);
        }

        //3、关闭资源
        fileInputStream.close();
    }

    private static void demo_write() throws IOException {
        //1、创建字节流输出对象，用于操作文件
        FileOutputStream fileOutputStream=new FileOutputStream("byteDemo.txt");

        //2、写数据，直接写入到了目的地中，不要刷新。
        fileOutputStream.write("love and peace".getBytes());

        //3、关闭资源
        fileOutputStream.close();
    }
}
