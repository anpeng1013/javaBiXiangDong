package day05;
/*
      静态代码块：
        随着类的加载而执行，而且只执行一次。
        作用：用于给全是静态成员的类加载时进行初始化。
        注意：静态代码块只能写在函数外边，因为静态代码块也可以看做一个函数。
                因此函数里面不能定义函数。

      构造代码块：
        创建对象时调用，给对象进行通用的一致的初始化
        与构造函数不同，调用不同的构造函数是给对应的对象进行针对性的初始化。

      局部代码块：
        在函数体的内部，用大括号{}包围的代码。
        作用：限定局部变量的生命周期。

静态代码块、构造代码块、构造函数的执行顺序：（详情见：day05.ExtendsDemo3.java）
    父类静态代码块--》子类静态代码块--》父类构造代码块--》父类构造函数
    --》子类显式初始化--》子类构造代码块--》子类构造函数。

 */
class Parent{
    protected String name;
    //静态代码块
    static {
        System.out.println("Parent static code block run");
    }
    //构造代码块
    {
        System.out.println("Parent construct code block run");
    }
    Parent(){
        System.out.println("Parent constructor run");
    }
    void show(){
        System.out.println("Parent show function  run");
    }
}

class Baby extends Parent{
    static {
        System.out.println("Baby static code block run");
    }

    {//构造代码块，创建对象时调用，给对象通用的初始化
        System.out.println("Baby construct code block run");
    }

    Baby(){//构造函数，是给对应的对象进行针对的初始化。
        System.out.println("Baby constructor run");
    }
}
public class StaticCodeDemo {
    static {
        System.out.println("main static code block run");
    }
    public static void main(String[] args) {
        new Baby();
    }
}
