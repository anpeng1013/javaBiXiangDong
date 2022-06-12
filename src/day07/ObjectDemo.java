package day07;
/*
Object:所有类的根类。（定义的不显示继承其他类的父类默认Object,从而子类
    间接继承object，子类不是直接继承object，因为java不支持多继承。）
    Object是不断抽取而来，具备着所有对象都有的共性功能。

    常用的共性内容：
    equals（Object object）：判断两个对象是否相等。比较的两个引用型变量的地址，
        即若两个引用型变量指向同一个对象，返回值为true，否则为false。
        该方法的参数为Object类型，运用多态原理，需要父类的地方可以用子类对象代替，
        即可以用于不同类型的两个对象之间的比较。等同于==，若不覆盖，功能略显多余。
    equals方法覆盖：
    一般都会覆盖此方法，根据对象的特有内容，建立判断对象是否相同的依据。

    hashCode();返回对象的十进制哈希值(不一定是对象地址的hash值），当复写equals方法时，必须复写hashcode方法。

    getClass();获取当前对象类型的字节码文件对象。

    toString();返回当前对象的字符串表示。等于getClass().getName()+'@'+Integer.toHexString(hashCode())
        建议所有子类都重写该方法。


 */
class Person{//默认继承Object根类
    private int age;
    private String name="anpeng";
    Person(int age){
        this.age=age;
    }
    public boolean equals(Object object){//方法覆盖。
        throw new ClassCastException("类型错误！");//如果不是Person类型，直接报告异常。
    }
    public boolean equals(Person person){//方法重载
        return this.age==person.age;
    }

//    public int hashCode(){//重写hashCode();
//        int result=name.hashCode();//若需要hash的字段是字符串，因为在java中String也是对象，所以可以调用hashCode方法。
//        return this.age;
//    }
    public String toString(){
        return "Person:"+age;
    }
}
class Demo{

}
public class ObjectDemo {
    public static void main(String[] args) {
        Person person=new Person(20);
        Person person1=new Person(20);
        Person person2=person;
        Demo demo=new Demo();
        System.out.println("equals方法：");
        System.out.println(person==person1);//比较的是引用变量的值等。
        System.out.println(person==person2);//比较的是引用变量的值等。
        System.out.println(person.equals(person1));//比较的是年龄是否相等。
        //System.out.println(person.equals(demo));//java.lang.ClassCastException: day07.Demo cannot be cast to day07.Person
        System.out.println("-----------");

        System.out.println("hashCode方法：");
        System.out.println(person);//打印对象类型和对象地址的十六进制哈希值
        System.out.println(person.hashCode());//打印对象十进制哈希值
        System.out.println(Integer.toHexString(person.hashCode()));//将对象的十进制哈希值转换为十六进制。
        System.out.println("-----------");

        System.out.println("getClass方法：");
        Class personClass=person.getClass();//获取当前对象的类型文件。
        Class personClass1=person1.getClass();
        System.out.println(personClass==personClass1);
        System.out.println(personClass.getName());
        System.out.println("-----------");

        System.out.println("toString方法：");
        System.out.println(person);//直接打印对象时，默认调用toString方法
        System.out.println(person.toString());//直接调用toString方法。
        System.out.println(person.getClass().getName()+'$'+Integer.toHexString(person.hashCode()));
        //toString方法的等价形式，将$换成@即可。
        System.out.println("-----------");
    }
}
