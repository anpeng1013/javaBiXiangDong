package day05;

public class Car {
    /*
  定义类其实就是在定义类中的成员。
      成员：成员变量<-->属性，成员函数<-->行为

  成员变量和局部变量的区别：
    1、成员变量定义在类中，整个类中都可以访问。
       局部变量定义在函数、语句、代码块中，只在所属区域有效。
    2、成员变量存在于堆内存的对象中。
       局部变量存在于栈内存的方法中。
    3、成员变量随着对象的创建而存在，随着对象的消失而消失。
       局部变量随着所属区域的执行而存在，随着所属区域的结束而释放。
    4、成员变量都有默认初始化值。
       局部变量没有默认初始化值。
   */

    static int wheel=4;
    private int num;
    String color;

    void run() {
        System.out.println(wheel+"..."+num + "..." + color);
    }

    void setNum(int num) {
        this.num = num;
    }

    void setColor(String color) {
        this.color = color;
    }
}
