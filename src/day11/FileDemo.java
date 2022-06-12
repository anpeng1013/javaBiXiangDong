package day11;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        constructorDemo();
    }

    private static void constructorDemo() throws IOException {
        //可以将一个已存在的，或者不存在的文件或目录封站成file对象。
        File file1=new File("E:"+File.separator+"ProgramProject"+File.separator+"Javaproject"
                +File.separator+"javaBiXiangDong"+File.separator);
        File file2=new File(file1,"fileClass_1.txt");

        System.out.println(file2.getParent());

        //创建实际的物理文件。

        file2.createNewFile();
    }
}
