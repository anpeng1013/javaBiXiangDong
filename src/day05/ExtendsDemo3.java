package day05;

/*
一个类的实例化过程：
Son s=new Son();
    1、JVM会读取指定路径下的Son.class文件，欲将子类加载进内存。
        如果有直接父类的情况下，会先加载Son的父类Father进内存，并执行父类的静态代码块。
        父类加载完后，再加载子类进内存，并执行子类的静态代码块。
    2、在堆内存中开辟空间，分配地址，给对象的属性进行默认初始化。
    3、调用子类对应的构造函数。
    5、在子类的构造函数中，第一行会先调用父类中的构造函数，
        对继承于父类的属性进行初始化。
    6、父类初始化完毕后，再对子类的属性进行显式初始化，显示初始化后，执行构造代码块。
    7、构造代码块执行完之后，再接着执行子类构造函数，对子类属性的特定初始化。
    8、子类构造函数执行完毕，将地址值赋给引用变量。

    父类静态代码块--》子类静态代码块--》父类构造代码块--》父类构造函数
    --》子类显式初始化--》子类构造代码块--》子类构造函数。
 */
class Father{
    int num=1;//显式初始化 --1
    //静态代码块
    static {
        System.out.println("fu static code block run");
    }
    {//构造代码块，详见day05.StaticCodeDemo.java   --2
        System.out.println("fu construct code run "+num);
    }
    Father(){
        super();//Father类继承于object类，但是object类随着JVM的启动就加载了
        //显示初始化
        // 构造代码块初始化
        num=2; //--3
        System.out.println("fu constructor run "+num);//--4
        show();// 调用的是子类的show方法，父类的被覆盖了。
        return;
    }
    void show(){
        //被子类的show覆盖。
        System.out.println("father show");
    }
}

class Son extends Father{
    int num=3;//显式初始化。 --6
    //静态代码块
    static {
        System.out.println("son static code block run");
    }
    {//构造代码块，详见day05.StaticCodeDemo.java  --7
        System.out.println("son construct code run  "+num);
    }
    Son(){
        super();//-->通过super初始化父类属性时，子类的成员变量并未初始化。等super()将父类初始化后，再进行子类的显式初始化。
        //显示初始化
        //构造代码块初始化。
        num=4;//--8
        System.out.println("son constructor run  "+num);//--9
        return;
    }
    void show(){
        //覆盖了父类的show方法 --5
        System.out.println("son explicit init run  "+num);
    }
}
public class ExtendsDemo3 {
    public static void main(String[] args) {
       //一个类实例化为对象的过程。
        new Son();
    }
}
