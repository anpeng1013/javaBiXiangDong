package day06;

/*
对象的多态性：
    一个对象对应着不同的类型。在代码中的体现是；
        父类或者接口的引用指向其子类的对象。

多态的好处：
    提高了代码的扩展性，前期定义的代码可以使用后期的内容。
多态的弊端：
    前期定义的内容不能使用后期子类的特有内容。
多态的前提：
    1、必须有关系，继承，实现。
    2、要有覆盖。

注意：
    1、对于转型，自始至终都是子类对象在做着类型的变化。
    2、不能将父类对象直接降格为子类对象，
        如Animal animal =new Animal(); Cat cat=(Cat)animal;这样是不可以的。
    3、父类引用指向子类对象，即需要父类的地方可以用子类替代。
        很好理解，可以说狗都是动物，但不能说动物都是狗。
    4、instanceof：用于判断对象的具体类型。
       只能用于引用数据类型判断。通常在向下转型前，用于健壮性的判断。
    5、对于static，final，private修饰的方法不可以被覆盖。

多态时成员的特点：
1、成员变量
    编译时：参考引用型变量所属的类中的是否有调用的成员变量，有则编译通过，没有则编译失败。
    运行时：参考引用型变量所属的类中的是否有调用的成员变量，并运行该所属类中的成员变量。
    简单说：编译和运行都参考等号的左边，面试题。
2、成员函数（非静态）
    编译时：参考引用型变量所属的类中是否有调用的函数，有则编译通过，没有则编译失败。
    运行时：参考引用型变量所指向的对象中是否有调用的函数。有则运行，没有则运行失败。
    简单说：编译看左边，运行看右边。
3、静态函数
    编译时：参考引用型变量所属的类中的是否有调用的静态方法，有则编译通过，没有则编译失败。
    运行时：参考引用型变量所属的类中的是否有调用的静态方法，并运行该所属类中的静态方法。
    简单说：编译和运行都参考等号的左边，面试题。、
            其实对于静态方法不需要对象，直接用类名调用。
 */
abstract class Animal {
    int num=0;
    abstract void eat();
    void show(){
        System.out.println("fu show");
    }
    static void method(){
        System.out.println("fu static");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("啃骨头...");
    }

    void lookHome() {
        System.out.println("看家");
    }
}

class Pig extends Animal {
    void eat() {
        System.out.println("吃饲料...");
    }

    void gongDi() {
        System.out.println("拱地");
    }
}

class Cat extends Animal {
    int num=4;
    void eat() {
        System.out.println("吃鱼...");
    }

    void catchMouse() {
        System.out.println("抓老鼠");
    }
    void show(){
        System.out.println("zi show");
    }
    static void method(){
        System.out.println("zi static");
    }
}

public class DuoTaiDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Animal animal = new Cat();//父类引用指向子类对象，即需要父类的地方可以用子类替代
        // 自动类型提升，猫对象提升到动物类型，就不能再访问猫的特有功能。
        //作用就是限制对特有功能的访问。向上转型，升格。

        System.out.println(animal.num);//多态时成员变量不存在覆盖，升格后只能访问到父类的成员变量。
        animal.show();//多态时成员函数存在覆盖，非静态函数依赖于对象。
        cat.method();//多态时静态函数依赖于类的类型。
        animal.method();//多态时静态函数不存在覆盖，升格后只能访问到父类的成员变量。

        Cat cat1 = (Cat) animal;//如果还想用具体动物猫的特有功能，
        //可以将该对象进行向下转型，降格。
        cat1.catchMouse();

        //对于转型，自始至终都是子类对象在做着类型的变化,不能将父类对象直接降格为子类对象。
       /*
        Animal animal1=new Dog();
        Cat cat2=(Cat)animal1;//ClassCastException: day06.Dog cannot be cast to day06.Cat
        */

        method(cat);
        method(dog);//父类引用指向子类对象，即需要父类的地方可以用子类替代。
        //很好理解，可以说狗都是动物，但不能说动物都是狗。
        method(new Pig());
    }

    public static void method(Animal animal) {
        animal.eat();
        if(animal instanceof Cat){//instanceof：用于判断对象的具体类型。
            // 只能用于引用数据类型判断。通常在向下转型前，用于健壮性的判断。
            Cat c=(Cat)animal;//向下转型。
            c.catchMouse();
        }
    }
}
