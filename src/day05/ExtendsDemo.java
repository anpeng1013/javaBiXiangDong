package day05;

/*
Person父类在Person.java中
继承的好处：
    1、提高了代码的复用性
    2、让类与类之间产生了关系，为第三个特征多态提供了前提。

    java中支持单继承，不直接继承多继承，但对c++中的多继承机制进行改良。
    单继承：一个子类只能有一个直接父类
    多继承：一个子类可以有多个直接父类（java中不允许，进行改良）。
            在java中通过“多实现”的方式在实现。
    多重继承：C继承B，B继承A。就会出现多重继承体系。

当要使用一个继承体系时
    1、查看该体系中的顶层类，了解该体系的基本功能。
    2、创建体系中的最小类对象，完成功能的使用。

定义继承的时机：
    当类与类之间存在所属关系的时候，就定义继承。
        所属关系：xxx是yyy中的一种，如狼和狗都是犬科中的一种。
                 也就是is a的关系。
class A{
    void show(){
        System.out.println("a");

    }
}
class B extends A{
    //单继承
    void show(){
        System.out.println("b");

    }
}
class C extends B{
    //多重继承，C在继承B的同时，因为B继承了A，所以C也继承了A。
}
class D extends A,B{
    //多继承，java中不允许,会报错。两个父类中有相同的方法时，不知道执行哪个方法，
    //会产生调用的不确定性，例如类D 的对象调用show方法时，不知道调用哪一个
    //父类的show方法。
}
 */

class Student extends Person{
//    String name;
//    int age;
    void study(){
        System.out.println("Student study");

    }
}

class  Worker extends Person{
//    String name;
//    int age;
    void work(){
        System.out.println("Worker work");

    }
}
public class ExtendsDemo {
    public static void main(String[] args) {
        Student student=new Student();
        student.name="anpeng";
        student.age=20;
        student.study();
    }
}
