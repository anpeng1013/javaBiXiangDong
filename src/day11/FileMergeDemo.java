package day11;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 文件合并其实就是用的序列化技术
 */
public class FileMergeDemo {
    public static void main(String[] args) throws IOException {
        File dir = new File("E:\\ProgramProject\\Javaproject\\javaBiXiangDong\\out\\partFile");
//        mergeFile(dir);
        mergeFile_2(dir);
    }

    private static void mergeFile_2(File dir) throws IOException {
        File[] files = dir.listFiles(new SuffixFilter(".properties"));
        if (files.length != 1)
            throw new RuntimeException(dir + ",该目录没有properties扩展名的文件或者不唯一");

        //记录配置文件对象
        File confile = files[0];

        //获取配置文件中的信息
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(confile);

        properties.load(fileInputStream);

        String filename = properties.getProperty("filename");
        int count = Integer.parseInt(properties.getProperty("partCount"));


        //获取该目录下所有碎片文件。
        File[] partFiles = dir.listFiles(new SuffixFilter(".part"));

        if (partFiles.length != count) {//count不减1，因为从0开始加的

            throw new RuntimeException("碎片文件不符合要求，个数不对!应该是"+count+"个");
        }

        //将碎片文件和流对象关联并存储到集合中
        ArrayList<FileInputStream> arrayList=new ArrayList<FileInputStream>();
        for (int i = 0; i < partFiles.length; i++) {

            arrayList.add(new FileInputStream(partFiles[i]));
        }


        //将多个流合并成一个序列流
        Enumeration<FileInputStream> enumeration = Collections.enumeration(arrayList);
        SequenceInputStream sis = new SequenceInputStream(enumeration);

        FileOutputStream fos = new FileOutputStream(new File(dir, filename));

        //字节输出流，写入效率慢，但是没有字符流的读一行从而写一行的便捷
        //但是可以通过用缓冲区提高效率，缓冲区可以自己定义，也可以使用BufferedOutputStream
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = sis.read(buffer)) != -1) {
            fos.write(buffer, 0, length);
            fos.flush();
        }

        //关闭流
        fos.close();
        sis.close();
    }

    public static void mergeFile(File dir) throws IOException {
        ArrayList<FileInputStream> arrayList = new ArrayList<FileInputStream>();

        File[] files = dir.listFiles();
        for (int x = 0; x < files.length; x++) {
            arrayList.add(new FileInputStream(String.valueOf(files[x])));
        }

        Enumeration<FileInputStream> enumeration = Collections.enumeration(arrayList);
        SequenceInputStream sis = new SequenceInputStream(enumeration);

        FileOutputStream fos = new FileOutputStream(new File(dir, "mergeFile.txt"));

        //字节输出流，写入效率慢，但是没有字符流的读一行从而写一行的便捷
        //但是可以通过用缓冲区提高效率，缓冲区可以自己定义，也可以使用BufferedOutputStream
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = sis.read(buffer)) != -1) {
            fos.write(buffer, 0, length);
            fos.flush();
        }

        //关闭流
        fos.close();
        sis.close();
    }
}
