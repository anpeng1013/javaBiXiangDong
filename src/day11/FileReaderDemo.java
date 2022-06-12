package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        //showFileReader();
        showFileReader_2();
    }

    private static void showFileReader() throws IOException {
        //创建读取字符数据的流对象。
        /**
         * 在创建读取流对象时，必须明确读取的文件。
         *
         * 用一个读取流对象关联一个已存在文件。
         */
        FileReader fileReader = new FileReader("demo.txt");

        //用Reader中的read方法读取字符。
        int ch = 0;
        while ((ch = fileReader.read()) != -1) {
            System.out.print((char) ch);
        }
        fileReader.close();
    }

    private static void showFileReader_2() throws IOException {
        //创建read(char[])读取文本数据
        FileReader fileReader = new FileReader("demo.txt");
        char[] buffer = new char[3];
       // int num = fileReader.read(buffer);//将读取到的字符存储到数组中。
        //System.out.println("num = " + num + ": " + new String(buffer));

        char[] buffer1 = new char[3];
        int length = 0;
        while((length=fileReader.read(buffer1))!=-1){
            System.out.print(new String(buffer1,0,length));
        }
    }

}
