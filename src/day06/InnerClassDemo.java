package day06;
/*
内部类一般用于类的设计
    分析事物时，发现描述的该事物中还有其他事物，而且这个其他事物
    还在访问被描述事物的内容。这时就把这个其他事物定义成内部类来描述。

内部类访问的特点：
1、内部类可以直接访问外部类中的成员。
     因为内部类持有了外部类的引用（外部类名.this），所以内部类可以直接访问外部类中的成员。包括私有成员。
     静态的成员内部类只能访问静态的外部类成员，非静态的成员内部类，即可访问静态也可访问非静态。
2、外部类要访问非静态成员内部类，必须建立非静态成员内部类的对象。
     因为外部类加载时，并不会加载非静态的成员内部类。
3、内部类可以存放在成员位置上，也可以存放在局部位置上。
     内部类可以分为：静态成员内部类，非静态成员内部类，局部内部类，匿名内部类（也是局部的）
4、局部内部类只能访问局部中被final修饰的局部变量。
     java1.8之后会自动加上final，也可以理解为在编译时，会内嵌到局部类的字节码文件中。
5、非静态的内部类不可以有静态成员变量和成员方法。
     因为static的语义就是，其他类能直接通过(外部类.内部类名.静态成员名）来访问内部类中的静态成员。
     而JVM的加载顺序是，类的加载，执行static变量的初始化，然后执行对象的创建，对象成员的默认初始化，再执行对象成员的显式初始化。
     我们把非静态成员内部类看作是外部类的实例变量，依赖于对象，需要依赖于外部类创建实例对象才会被加载到内存中，所以当我们通过
     外部类名.内部类名.静态成员名，来访问非静态成员内部类中的静态成员，此时外部类已经加载到内存中且未创建对象，但是此刻非静态的
     成员内部类需要通过外部类先创建对象才能加载内存，也即该内部类的静态成员并未加载，访问不到。
     所以非静态的内部类不可以有静态成员变量和成员方法。

内部类有以下几种：
    非静态成员内部类：内部类在外部类的成员变量位置上，成员内部类的创建需要依赖外部类的对象创建而创建。
                      Outer.Inner inner=new Outer().new Inner();，所以不能调用外部类的非静态成员。
    静态成员内部类：相当于一个外部类，因为是静态的，属于类，而不依赖于对象，所以可以通过类名.静态内部类名();的方式创建对象，
                    Outer.Inner2 inner2=new Outer.Inner2();只能调用外部类的静态成员。
    局部内部类：局部内部类也叫方法内部类，在外部类的方法体中，在Java中，局部内部类相当于一个局部变量，所以不能被static修饰。
                  java中的局部变量不允许被static修饰，原因：1、无意义，2、耗内存，方法执行完后存放该静态局部变量，该静态局部变量
                  的生命周期就结束了，不能被其他方法访问到，但它却占据着静态内存空间。
    匿名局部内部类：就是内部类的简写格式，其实也就是一个匿名子类对象。
                必须有前提：
                内部类必须继承或者实现一个外部类或者接口。
                格式为：new 父类或接口名（）{子类内容};
               使用场景：当函数参数是接口类型时，而且接口中的方法不超过三个。 可以用匿名内部类作为实际参数进行传递。
 */

abstract class Father{
    abstract void show();
}

interface Inter{
    public abstract void show1();
    public abstract void show2();
}
class Outer{
    private int num=3;
    private int var=3;
    private static int id=2;

    class Inner{//成员内部类
        int var=4;
        void show(){
            System.out.println("member Inner show num..."+num);
        }
        void getVar(){
            int var=5;
            System.out.println("local var is "+var);
            System.out.println("Inner var is "+Inner.this.var);//此处的Inner可以省略
            System.out.println("Outer var is "+Outer.this.var);
        }
    }

    public void method(){
        Inner inner=new Inner();
        inner.show();
    }
    static class Inner2{//静态内部类，相当于一个外部类。
        void show(){
            System.out.println("Inner2 show id..."+id);
        }
        static void function(){//如果内部类中定义了静态成员，该内部类也必须是静态的。
            System.out.println("static function show id..."+id);
        }
    }

    public void function(){
        final int x=9;//java1.8之后会自动加上final，也可以理解为在编译时，会内嵌到局部类的字节码文件中。
        class Inner3{//局部内部类
            void show(){
                System.out.println("local Inner show id..."+id);
                System.out.println("local Inner show x..."+x);
            }
        }
        Inner3 inner3=new Inner3();
        inner3.show();
        new Father(){//匿名(anonymous)局部内部类，其实就是一个匿名的子类对象
            @Override
            void show() {
                System.out.println("匿名局部内部类：");
                System.out.println("anonymous access x..."+x);
            }
        }.show();
        Inter inter=new Inter() {//给匿名内部类起个父类的名字，这里用到多态，即父类引用指向子类对象。
            @Override
            public void show1() {
                System.out.println("anonymous apply show1");
            }

            @Override
            public void show2() {
                System.out.println("anonymous apply show2");
            }
        };
        inter.show1();
        inter.show2();
    }
}

public class InnerClassDemo {

    public static void main(String[] args) {

        //间接访问内部类的成员
        System.out.print("间接访问内部类：");
        Outer outer=new Outer();
        outer.method();

        //直接访问内部类的成员。
        System.out.print("直接访问内部类：");
        Outer.Inner inner=new Outer().new Inner();
        inner.show();

        //如果内部类是静态的。相当于一个外部类。
        System.out.print("静态内部类只能访问静态的外部成员：");
        Outer.Inner2 inner2=new Outer.Inner2();
        inner2.show();

        //如果内部类是静态的，且成员也是静态的。
        System.out.print("内部类有静态成员则该类一定静态：");
        Outer.Inner2.function();

        //对于外部类和内部类中的成员变量以及局部变量重名时
        System.out.println("内部类和外部类以及局部中变量重名：");
        inner.getVar();

        //局部内部类访问局部变量时，该变量必须是final修饰的。
        System.out.println("局部外部类直接访问外部成员和局部变量：");
        new Outer().function();

        /*匿名内部类的使用场景：当函数参数是接口类型时，而且接口中的方法不超过三个。
                                可以用匿名内部类作为实际参数进行传递。*/
        show(new Inter() {
            @Override
            public void show1() {
                System.out.println("anonymous apply show3");
            }

            @Override
            public void show2() {
                System.out.println("anonymous apply show4");
            }
        });
        //面试题：
        //new Inner();//此处new Inner();创建匿名对象会报错，因为Inner相当于非静态的实例变量
        //而主函数是静态的，静态不能调用非静态。只有在非静态方法中才可以。
    }

    class Inner{}

    public static void show(Inter inter){
        inter.show1();
        inter.show2();
        new Object(){//创建一个匿名的Object类的子类对象
            //这里不能用Object的引用指向这个子类对象，因为非静态方法的多态时，
            // 这个匿名子类对象被升格为Object类型，编译看左边，
            // 而Object类中没有show方法，所以编译会失败。
          public void show(){
              System.out.println("anonymous apply show5");
          }
        }.show();
    }
}
