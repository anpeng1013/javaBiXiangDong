package day03;

public class ForForTest3 {
    public static void main(String[] args) {
        /*
        九九乘法表
        1*1=1
        1*2=2 2*2=4
        1*3=3 2*3=6 3*3=9
         */
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"\t\t");
            }
            System.out.println();
        }
        /*
        \n: 换行
        \t: 制表符
        \b: 退格
        \r:按下回车键
        Windows系统中回车符其实是由两个符号组成的 \r\n.
        Linux中回车符是 \n.
         */
        System.out.println("hello\nworld");//在字符串中使用\n可以换行
        System.out.println("hello\tworld");//在字符串中使用\t用作制表符
        System.out.println("\"helloworld\"");
    }
}
