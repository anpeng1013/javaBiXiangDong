package day02;

public class OperateDemo2 {
    public static void main(String[] args) {
        //赋值运算符 = += -= *= /= %= 会自动强制类型转换
        //面试题,下面两个表达式的区别
        short s = 3;//赋值，一次运算，会自动类型检查，超出后会自动强制转换
        s += 4;//也是赋值，一次运算，会自动类型检查，超出后会自动强制转换
//        s=s+4; //会出现编译错误，因为s是2个字节且是变量。可能会超出范围,如果s是int类型则不会编译报错
        //因为字面常量就是int类型的。
        s=(short)(s+4);//编译不会报错
        System.out.println(s);
    }
}
