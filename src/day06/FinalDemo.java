package day06;
/*
final关键字：
1、final是一个修饰符，可以修饰类，方法，变量。
2、final修饰的类不可以被继承。
3、final修饰的方法不可以被子类覆盖。
4、final修饰的变量是一个常量，只能赋值一次。
5、常量名用大写，变量名用小写。常量一般加静态，且必须显式赋初值。
    为什么用final修饰变量？
        原因：其实在程序中，如果一个数据是固定的，那么直接使用这个
     数据就可以了，但是这样阅读性差，所以该给数据起个名称。而且这个
     数据的值不能变化，所以加上final固定。

     写法规范：常量所有字母都是大写，多个单词时中间有下划线_连接。
 */
class Fu{
    void method(){
        //调用底层系统的资源。
        System.out.println("该方法将调用底层系统资源");
    }
}

class Zi extends Fu{
    public static final double NUMBER=10;//全局常量
    void method(){
        System.out.println("hello,world");
        //覆盖了父类的方法，打破了父类对该方法的封装。所以可以对父类的方法
        //加final修饰，防止子类对父类的覆盖。
    }
}
public class FinalDemo {
    public static void main(String[] args) {
        System.out.println(Zi.NUMBER);
    }
}
