package day10;

import day09.javaBean.Person;

//实现泛型接口时，就明确参数的类型。
class  ImplementGenericsInterface_1 implements GenericsInterface<String>{
    @Override
    public void show(String string) {
        System.out.println("string = " + string);
    }
}

//实现泛型接口时，仍然不明确参数的类型，直到运行时才确定。
class ImplementGenericsInterface_2 <E> implements GenericsInterface<E>{
    @Override
    public void show(E e) {
        System.out.println("e = " + e);
    }
}
public class GenericsInterFaceDemo {
    public static void main(String[] args) {
        ImplementGenericsInterface_1 igi=new ImplementGenericsInterface_1();
        igi.show(new String("apple"));

        ImplementGenericsInterface_2 igi2=new ImplementGenericsInterface_2();
        igi2.show(new Person("安鹏",24));
    }
}
