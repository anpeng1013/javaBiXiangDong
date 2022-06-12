package day10;

import java.util.Map;

public class MathDemo {
    public static void main(String[] args) {
        /*
        Math类提供了操作数学运算的方法 ，都是静态的。
        常用方法：
        abs():返回绝对值。
        ceil();返回大于参数的最小整数
        floor();返回小于参数的最大整数
        round();返回四舍五入的整数。
        pow(a,b);返回a的b次方。
        random();返回一个0到1的随机数。
         */
        double d= Math.ceil(12.56);
        double d1=Math.floor(12.56);
        double d2=Math.round(12.56);
        double d3=Math.pow(2,3);

        System.out.println("d = " + d);
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);
    }
}
