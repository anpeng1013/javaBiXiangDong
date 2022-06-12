package day11;

import java.io.*;
import java.util.*;

public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 需求：将demo_2.txt demo_3.txt demo_4.txt文件中
         * 数据合并到一个文件中。
         */
//        Vector<FileInputStream> v=new Vector<FileInputStream>();
//        v.add(new FileInputStream("demo_2.txt"));
//        v.add(new FileInputStream("demo_3.txt"));
//        v.add(new FileInputStream("demo_4.txt"));
//        Enumeration<FileInputStream> enumeration=v.elements();

        //Vector速度慢，用ArrayList
        ArrayList<FileInputStream> arrayList=new ArrayList<FileInputStream>();
        for (int i = 2; i <=4; i++) {
            arrayList.add(new FileInputStream("demo_"+i+".txt"));
        }

//        Iterator<FileInputStream> iterator=arrayList.iterator();
//        Enumeration<FileInputStream> enumeration=new Enumeration<FileInputStream>() {
//            @Override
//            public boolean hasMoreElements() {
//                return iterator.hasNext();
//            }
//
//            @Override
//            public FileInputStream nextElement() {
//                return iterator.next();
//            }
//        };
        //上面ArrayList中没有枚举，但是可以通过迭代器，和匿名内部类（枚举的子类对象）来实现
        //其实就是Collections中的静态方法enumeration()的原理
        Enumeration<FileInputStream> enumeration1= Collections.enumeration(arrayList);

        SequenceInputStream sequenceInputStream=new SequenceInputStream(enumeration1);

        //将目的文件与输出流关联起来，若目的文件不存在，则创建。
        FileOutputStream fileOutputStream=new FileOutputStream("demo_234.txt");

        byte[] buffer=new byte[1024];
        int length=0;
        while ((length=sequenceInputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,length);
        }
        fileOutputStream.close();
        fileOutputStream.close();
    }
}
