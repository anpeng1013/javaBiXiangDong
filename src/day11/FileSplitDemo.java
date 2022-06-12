package day11;

import java.io.*;
import java.util.Properties;

/**
 * 文件切割器
 */
public class FileSplitDemo {
    public static void main(String[] args) throws IOException {
        //splitFile(new File("classFileList.txt"));
        splitFile_2(new File("classFileList.txt"));
    }

    /**
     * 文件切割函数2.0 带有被切割文件配置信息的切割
     * @param file 被切割文件
     * @throws IOException
     */
    private static void splitFile_2(File file) throws IOException {
        //用读取流关联源文件
        FileInputStream fileInputStream = new FileInputStream(file);

        //字节输出流，写入效率慢，但是没有字符流的读一行从而写一行的便捷
        //但是可以通过用缓冲区提高效率，缓冲区可以自己定义，也可以使用BufferedOutputStream
        //定义一个1KB的缓冲区
        byte[] buffer = new byte[1024];

        //创建目的
        FileOutputStream fileOutputStream = null;
        int length = 0;
        int count = 0;

        /**
         * 切割文件时，必须记录被切割文件的名称，以及碎片文件个数，以方便合并。
         * 这个信息为了进行简单的描述，使用键值对的方式，用到了properties对象。
         */
        Properties properties=new Properties();

        File dir = new File("E:\\ProgramProject\\Javaproject\\javaBiXiangDong\\out\\partFile");
        if (!dir.exists())
            dir.mkdirs();
        while ((length = fileInputStream.read(buffer)) != -1) {
            fileOutputStream=new FileOutputStream(new File(dir,"classFileList"+(count++)+".part"));
            fileOutputStream.write(buffer,0,length);
            fileOutputStream.close();
        }

        //将被切割文件的信息保存大properties集合中
        properties.setProperty("partCount",count+"");
        properties.setProperty("filename",file.getName());

        //将properties集合中的数据存储到文件中。
        fileOutputStream=new FileOutputStream(new File(dir,count+".properties"));
        properties.store(fileOutputStream,"save file info");

        fileOutputStream.close();
        fileInputStream.close();
    }

    /**
     * 文件切割函数
     * @param file 被切割文件
     * @throws IOException
     */
    public static void splitFile(File file) throws IOException {
        //用读取流关联源文件
        FileInputStream fileInputStream = new FileInputStream(file);

        //字节输出流，写入效率慢，但是没有字符流的读一行从而写一行的便捷
        //但是可以通过用缓冲区提高效率，缓冲区可以自己定义，也可以使用BufferedOutputStream
        //定义一个1KB的缓冲区
        byte[] buffer = new byte[1024];

        //创建目的
        FileOutputStream fileOutputStream = null;
        int length = 0;
        int count = 0;
        File dir = new File("E:\\ProgramProject\\Javaproject\\javaBiXiangDong\\out\\partFile");
        if (!dir.exists())
            dir.mkdirs();
        while ((length = fileInputStream.read(buffer)) != -1) {
            fileOutputStream=new FileOutputStream(new File(dir,"classFileList"+(count++)+".part"));
            fileOutputStream.write(buffer,0,length);
        }
        fileOutputStream.close();
        fileInputStream.close();

    }
}
