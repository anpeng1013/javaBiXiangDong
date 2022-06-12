package day02;

public class OperateDemo3 {
    public static void main(String[] args) {
        //比较运算符 == <= >= < > != 运算结果只能是true或false
        //==当比较的是对象时，比较的是对象的地址是否相同。
        //当比较的是基本类型数据时，比较的是数据的值是否相同。
        System.out.println(3 > 2);
        System.out.println(2 != 3);
        System.out.println(2 == 3);

        //逻辑运算符 &与  |或  用于连接两个Boolean类型的表达式
        /*
        面试题：
        &单与：不管左右两边表达式是否为真，都参与运算。
        &&双与（短路）：当左边为假时，右边就不参与运算了，两者的运算结果一样。

        |单或:不管左右两边表达式是否为真，都参与运算。
        ||双或：当左边为真时即为真，右边就不参与运算了。左边为假时，再计算右边的表达式。两者的运算结果一样。

        &：当左右两边是两个整数时，看作是位运算中的各位相与
        100和011各位相与，得010

        |：当左右两边是两个整数时，看作是位运算中的各位或
         */
        int x = 1;
        System.out.println(x > 2 & x < 5);
        System.out.println(4 | 8);

    }
}
