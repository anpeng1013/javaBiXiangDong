package day11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        showBufferedWriter();
    }

    private static void showBufferedWriter() throws IOException {
        FileWriter fileWriter=new FileWriter("demo_4.txt");

        //为了提高写入效率，使用字符流的缓冲区。
        //创建一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联。
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

        //使用缓冲区的写入方法将数据写入到缓冲区中。
        bufferedWriter.write("love and peace");

        //使用缓冲区的刷新方法将数据刷新到目的地中。
        bufferedWriter.flush();

        //关闭缓冲区,其实关闭的就是被缓冲的流对象。
        bufferedWriter.close();
    }
}
