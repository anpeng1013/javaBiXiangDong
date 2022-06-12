package day11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile：不是IO体系中的子类
 * <p>
 * 特点：
 * 1、该对象即能读，又能写。
 * 2、该对象内部维护一个byte数组，并通过指针可以操作数组中的元素
 * 3、可以通过getFilePointer方法获取指针的位置，和通过seek方法设置指针的位置。
 * 4、其实该对象就是将字节输入流和输出流进行了封装。
 * 5、该对象的源或者目的只能是文件，通过构造函数就可以看出。
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
//        writeFile();//连续写
        writeFile_1();//随机写
//        readFile();//连续读
//        readFile_1();//随机读
    }

    private static void writeFile_1() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("randomAccessFile.txt", "rw");
        int pos= (int) raf.getFilePointer();
        System.out.println("在" + pos+"位置写入：");
        raf.write("王五".getBytes());
        raf.writeInt(100);
        readFile();

        raf.seek(20);
        pos= (int) raf.getFilePointer();
        System.out.println("在" + pos+"位置写入：");
        raf.write("赵六".getBytes());
        raf.writeInt(101);
        readFile();
        readFile_1();
    }

    private static void readFile_1() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("randomAccessFile.txt", "rw");
        byte[] buffer = new byte[6];
        //通过seek设置文件读取指针的位置，直接读小强或赵六
        raf.seek(1*20);

        raf.read(buffer);
        String name=new String(buffer);
        System.out.println("name = " + name);
        int age=raf.readInt();
        System.out.println("age = " + age);
    }

    private static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("randomAccessFile.txt", "rw");
        byte[] buffer = new byte[6];
        //读张三
        raf.read(buffer);
        String name=new String(buffer);
        System.out.println("name = " + name);
        int age=raf.readInt();
        System.out.println("age = " + age);

        //接着读小强
        raf.read(buffer);
        name=new String(buffer);
        age=raf.readInt();
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        raf.close();
    }

    /**
     * 使用RandomAccessFile对象写入一些人员信息，比如姓名和年龄。
     * <p>
     * 如果文件不存在，则创建，如果文件存在则不创建。
     */
    private static void writeFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("randomAccessFile.txt", "rw");
        raf.write("张三".getBytes());//两个汉字6字节
//        raf.write(97);//写入的是1个字节
//        raf.write(609);//写入的还是1个字节，高位被舍弃
        raf.writeInt(97);//写入4个字节
        raf.write("小强".getBytes());
        raf.writeInt(99);//完整的写入32位整数。4个字节
        raf.close();
    }
}
