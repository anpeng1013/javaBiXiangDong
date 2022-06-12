package day02;

public class OperateTest {
    public static void main(String[] args){
        //最有效率的方式算出2乘以8的结果？
        System.out.println(4<<3);

        //对两个整数变量的值进行互换（不需要第三方变量）
        int a=3,b=5;
        System.out.println("before:a="+a+",b="+b);
        int c;
        /* 需要使用第三方变量，常用方法，阅读性好，开发时实际用这种。
        c=a;
        a=b;
        b=c;
         */


        /*不需要第三方变量
        这种方式一般不使用，因为如果连个整数的数值过大，会超出int的表示范围
        ，会强制转换，数据会变化
        a=a+b;//a=3+5;a=8;
        b=a-b;//3+5-5=3;b=3;
        a=a-b;//3+5-3=5;a=5;
         */

        a=a^b;//a=3^5;不需要第三方变量，性能最好，面试时用。
        b=a^b;//b=(3^5)^5;b=3;一个数异或同一个数两次，结果还是这个数
        a=a^b;//a=(3^5)^3;a=5;一个数异或同一个数两次，结果还是这个数
        System.out.println(" after:a="+a+",b="+b);
    }
}
