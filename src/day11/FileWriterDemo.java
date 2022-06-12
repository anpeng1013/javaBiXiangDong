package day11;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //showFileWriter();
        showFileWriterDetail();
    }

    private static void showFileWriter() throws IOException {
        //创建一个可以往文件中写入字符数据的字符输出流对象。
        /**
        既然是往一个文件中写入文字数据，那么在创建对象时，就必须
        明确该文件（即用于存储数据的目的地）。
        如果文件不存在，则会被自动创建。
        如果文件存在，则会被覆盖。
         */
        FileWriter fileWriter=new FileWriter("demo.txt");

        /**
         *调用Writer对象中的write(String)方法，写入数据.
         * 此时，其实数据被写入到了临时存储缓冲区中，还未
         * 写入到目标文件中，需要flush方法。
         */
        fileWriter.write("hello world!");
        fileWriter.write( "\nanpeng love huli");

        /**
         * 调用Writer对象的flush方法，对临时存储缓冲区进行刷新
         * 将缓冲区中的数据立即写入到目标文件中。
         */
        //fileWriter.flush();

        /**
         * 关闭写入流，关闭资源。在关闭前会调用flush方法。
         *
         */
        fileWriter.close();
    }


    private static void showFileWriterDetail() throws IOException {
        //演示FileWriter的换行。
        FileWriter fileWriter=new FileWriter("demo.txt",true);
        fileWriter.write("hello world\nlove");
        fileWriter.flush();

        //如果构造函数中加入true，可以实现对文件的续写（1.8后不加也可以）。
        //演示FileWriter的续写
        fileWriter.append(" hulil");
        fileWriter.flush();
        fileWriter.close();
    }

}
