package day11;

import java.io.UnsupportedEncodingException;

public class encodeDemo {
    /**
     * 字符串-->字节数组：编码
     * 字节数组-->字符串：解码
     *
     * 你好：GBK：-60 -29 -70 -61
     *       UTF-8：-28 -67 -96 -27 -91 -67
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
         String str="你好";

         //编码
        byte[] buffer=str.getBytes("utf-8");
//        printBytes(buffer);

        //解码
        String str1=new String(buffer,"gbk");
        System.out.println("str1 = " + str1);
    }

    private static void printBytes(byte[] buffer) {
        for (byte b:buffer){
            System.out.print(b+" ");
        }
    }
}
