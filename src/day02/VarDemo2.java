package day02;

public class VarDemo2 {
    public static void main(String[] args) {

        /*
        基本数据类型：
            1、整数型：byte，char，short，int，long，char也叫字符型，对应ASCII码。
            2、浮点型：float，double
            4、布尔型：boolean
         */
        //自动类型转换 (byte、char、short）-->int-->long-->float-->double
        byte b = 5;
        int i = b;//byte-->int
        long l=i;//int-->long
        float f=l;//long-->float
        double d=l;//long-->double
        boolean bool=true;

        //强制类型转换，5是int型。
        byte x = 3;
        x = (byte) (x + 200);
        System.out.println(x);
        System.out.println(i);

        //字符运算
        System.out.println((char) ('a' + 1));
        System.out.println('你' + 0);//unicode 国际编码表

        byte b1 = 3;
        byte b2 = 4;
        byte b3;
        // b3 = b1 + b2;因为b1和b2是变量，不能做类型检查，有可能超出byte范围，所以会报错。
        //把b3改为int类型则不会报错，因为int四个字节一定可以表示最大的两个byte整数的和。

        int x1 = Integer.MAX_VALUE;//Integer.MAX_VALUE表示int的最大整数即7FFF FFFF
        int x2 = 1;
        int x3;
        x3 = x1 + x2;//最大正数加1之后，变成了最小的负数。
        //不会报错，因为计算机默认整数运算是int，即使两个最大的int整数相加，其和也会被
        //强制转换成int。
        System.out.println(x1);
        System.out.println(x3);
    }
}
