package day06;
/*
    接口：
      当一个抽象类中的方法都是抽象的时候，这时可以将该抽象类用另一种
    形式定义和表示，就是接口，interface。
    abstract class AbsDemo{
        abstract void method1();
        abstract void method2();
    }
    接口可以看做特殊的抽象类，其中全是抽象方法。
    接口中的常见成员：（而且这些成员都有固定的修饰符,若不写，会自动加上）
        1、全局常量：public static final
        2、抽象方法：public abstract
            固定的修饰符组合，要写全，否则阅读性极差。

    接口和抽象类的异同点：
        相同点：
            都是不断向上抽取而来的。
        不同点：
            1、抽象类需要被继承，而且只能是单继承。
                接口需要被实现，而且可以多实现。
            2、抽象类可以定义抽象方法和非抽象方法，子类继承后，可以直接使用抽象方法。
                接口中只能定义抽象方法，必须由子类去实现。
            3、抽象的继承，是is a关系。在定义该体系的基本共性内容
                接口的实现时like a关系。在定义该体系的额外功能。

    接口的特点：
    1、接口是对外暴露的规则
    2、接口是程序的功能扩展
    3、接口的出现降低耦合性。
    4、接口可以被类多实现，也可以被接口多继承。

    注意细节：
    1、类与类之间是继承关系，类与接口之间是实现关系。
      接口不可以实例化，只能由实现接口的子类覆盖接口的所有抽象方法后，
    该子类才可以实例化，否则，这个子类就是一个抽象类。

    2、在java中不直接支持多继承，因为会出现调用的不确定性。
       所以java将多继承机制进行改良，因为在java中变成了多实现。

    3、一个类可以实现多个接口，多实现时，接口的全局变量不可以重名
        但是多实现时，接口的方法可以重名，因为反正都会被覆盖

    4、一个类在继承另一个类的同时，还可以实现多个接口。

    5、接口的出现避免了单继承的局限性。一般功能扩展都用接口来实现。

    6、接口与接口之间是继承关系，而且接口可以多继承。
        原因：java中类不支持多继承就是因为同名的父类方法的不同方法体导致执行的不确定性。
      而在接口中，因为抽象方法没有方法体，即使同名，依旧会被实现接口的子类覆盖重写，
      所以不存在执行时的不确定性，即java中接口可以多继承。

*/

//定义接口，用关键字interface
interface  IntDemoA{
    public static final int NUM=10;

    public abstract void method1();
    //多实现时，接口的方法可以重名，因为反正都会被覆盖
    public abstract void method2();
}
interface  IntDemoB{
    //public static final int NUM=10;
    // 多实现时，接口的全局变量不可以重名。

    public abstract void method1();

}
interface IntDemoC extends /*接口的多继承*/IntDemoA,IntDemoB{
    //接口与接口之间是继承关系，而且接口可以多继承
    public abstract void method3();
}

class DemoAa{
    public void method(){
        System.out.println("Something DemoAa can do.");
    }
}
class DemoImpl extends DemoAa implements /*类的多实现*/ IntDemoA,IntDemoB,IntDemoC{
    public void method(){
        System.out.println("I override method");
    }
    @Override
    public void method1(){
        System.out.println("I implement method1");

    }

    @Override
    public void method2() {
        System.out.println("I implement method2");
    }

    @Override
    public void method3() {
        System.out.println("I implement method3");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        DemoImpl demo=new DemoImpl();
        System.out.println(demo.NUM);
        System.out.println(DemoImpl.NUM);
        System.out.println(IntDemoA.NUM);
        demo.method();
        demo.method1();
        demo.method2();
        demo.method3();
    }
}
