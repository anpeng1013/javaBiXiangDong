package day11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo {
    //需求：将C盘的一个文本文件复制到E盘。
    /**
     * 思路：
     *  1、需要读取源
     *  2、将读到的数据写到目的地。
     *  3、既然是操作文本数据，使用字符流。
     *  4、关闭流资源。
     */
    public static void main(String[] args) throws IOException {
        FileReader fileReader=new FileReader("demo.txt");
        FileWriter fileWriter=new FileWriter("demo_2.txt");

        int ch=0;
        while((ch=fileReader.read())!=-1){
            fileWriter.write(ch);
        }
        fileWriter.close();
        fileReader.close();
    }
}
