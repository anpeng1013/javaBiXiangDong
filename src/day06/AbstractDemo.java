package day06;

/*
抽象类：
    抽象：笼统，模糊，不具体。
特点：
    1、方法只有声明，没有实现时，该方法就是抽象方法，需要被abstract修饰。
        抽象方法必须定义在抽象类中，该类必须也被abstract修饰。
    2、抽象类不可以被实例化，即不可以new对象。
        因为调用抽象方法没有意义
    3、抽象类必须由其子类覆盖了所有的抽象方法后，该子类才可以实例化，
        否则，该子类还是抽象类。

抽象类的细节：
    1、抽象类有构造函数吗？
        有，用于给子类对象进行初始化。

    2、抽象类可以不定义抽象方法吗？
        可以，但是很少见。目的就是不让该类创建对象。
        AWT中的适配器对象就是这种类，通常这种类中的方法有方法体，但是
        没有内容。如下
        class Demo{
            void show1();//没有方法体。
            void show2(){}//空方法体。
        }
    3、抽象关键字abstract不可以和哪些关键字共存？
        private不行，因为私有的抽象方法不能被子类继承，继而不能被覆盖实现。
        static 不行，因为可以通过类名调用静态抽象方法，但是抽象方法无意义。
        final  不行，因为final修饰的方法不能被覆盖实现。

    4、抽象类和一般类的区别?
        相同点：
            抽象类和一般类都是用来描述事物的，都在内部定义了成员。
        不同点：
            1、一般类有足够的信息描述事物。
                抽象类描述事物的信息可能不足。
            2、一般类中不可以定义抽象方法。只能定义非抽象方法。
                抽象类中可定义抽象方法，同时也可以定义非抽象方法。
            3、一般类可以被实例化。
                抽象类不可以被实例化。

    5、抽象类一定是个父类吗？
        是的。因为需要子类覆盖抽象方法后，子类才可以被实例化。
 */
abstract class Demo{
     abstract/*抽象方法*/ void show();
}
class DemoA extends Demo{
    void show(){
        System.out.println("demo a show");
    }
}
class DemoB extends Demo{
    void show(){
        System.out.println("demo b show");
    }
}
abstract class 犬科{//java中使用Unicode码，可以识别中文。
    abstract void 吼叫();
}
class 狗 extends 犬科{
    void 吼叫(){
        System.out.println("汪汪...");
    }
}
class 狼 extends 犬科{
    void 吼叫(){
        System.out.println("嗷嗷...");
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        狗 中华田园犬=new 狗();
        中华田园犬.吼叫();
        DemoA demoA=new DemoA();
        demoA.show();
    }
}
