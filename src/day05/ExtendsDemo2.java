package day05;

/*
在子父类中，成员的特点体现：
1、成员变量。
    当本类的成员和局部变量同名时用this区分。
    当子父类中的成员变量同名时 用super区分父类。
    this和super的用法很相似:
    this:代表一个本类对象的引用
    super：代表一个本类中的父类空间的引用，该父类空间中
           存储了继承于父类的成员变量。

2、成员函数。
    当子父类中出现成员函数相同的情况，会运行子类的函数。
    这种现象，称为覆盖操作。这是函数在子父类中的特性。
    函数两个特性：
        1、重载：在同一个类中。overload
        2、覆盖：子类中对父类同名函数的重写，复写。override。

    覆盖注意事项：
        1、子类方法覆盖父类方法时，子类权限必须大于等于父类的权限。
        2、静态只能覆盖静态，或被静态覆盖。

    使用覆盖操作的时机：
        当对一个进行子类的扩展时，子类需要保留父类的功能声明，
        但是要定义子类中该功能的特有内容时，就使用覆盖操作。

3、构造函数。
    在子类构造对象时，调用子类构造函数之前，先调用了父类构造函数
        原因：在子类的构造函数中的第一行有一个默认的隐式语句：super();
    子类的实例化过程：子类中所有的构造函数默认都会访问父类中的
                      空参数的构造函数。详细过程参见ExtendsDemo3.java。

    为什么子类实例化的时候要访问父类中的构造函数呢？
        因为子类继承了父类，获取到了父类中的非私有内容（属性），
        所以在使用父类内容之前，要先看父类如何对自己内容进行初始化的。
        所以子类在构造对象时，必须访问父类中的构造函数。

     注意：
         * 若父类中没有空参数构造函数，那么子类构造函数必须要用super语句
           明确要调用的父类中的哪个构造函数，否则会报错。
         * 若子类构造函数中如果使用this调用了本类构造函数时，此时super就没有了
            因为super和this都只能定义在第一行，所以只能有一个。但是可以保证的是
            子类中肯定会有其他的构造函数会访问父类的构造函数。
         * super语句必须要定义在子类构造函数的第一行。因为父类的初始化工作要先完成。
         * java中默认所有类都继承于Object。

 */
class Fu{
    private int num=4;
    public int getNum(){
        return num;

    }
    Fu(){
        System.out.println("fu A run");

    }
    Fu(int num){
        System.out.println("fu B run "+num);
    }
    void show(){
        System.out.println("工作");

    }
}
class Zi extends Fu{
    int num=5;

    Zi(){
        //super();//默认调用的就是父类中的空参数构造函数，
        //若父类中没有空参数构造函数，那么子类构造函数必须要用super语句明确
        // 要调用的父类中的哪个构造函数，否则会报错。
        //super(4);//有参构造函数和无参构造函数只能调用一个。
        System.out.println("zi C run");
    }
    Zi(int num){
        System.out.println("zi D run "+num);
    }
    void showNum(){
        System.out.println(this.num+"....."+super.getNum());
        //子类不能直接访问父类中私有内容，但是可以间接访问。
    }
    void show(){
        System.out.println("学习");
        super.show();

    }
}
public class ExtendsDemo2 {
    public static void main(String[] args) {
        Zi zi=new Zi();//继承中的构造函数的特性。
        zi.showNum();//继承中的成员变量的特性
        zi.show();//继承中的成员函数的特性。覆盖
        new Zi(5);//继承中的子类实例化过程。
    }
}
