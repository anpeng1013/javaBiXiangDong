package day11;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {
    /**
     * 字节数组流的源和目的都在内存中，源是一个给定大小的数组
     *    目的是个动态数组，所以不需要指定大小。
     *
     *  此外还有字符数组流，字符串流。
     * @param args
     */
    public static void main(String[] args) {
        ByteArrayInputStream bais = new ByteArrayInputStream("anpeng".getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch=0;
        while((ch=bais.read())!=-1){
            baos.write(ch);
        }
        System.out.println(baos.toString());
    }
}
