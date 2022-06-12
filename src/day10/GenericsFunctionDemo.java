package day10;

import day09.javaBean.Person;

/**
 * 将泛型定义在方法上。
 */
public class GenericsFunctionDemo {
    public static void main(String[] args) {
        Tool<Person> tool=new Tool<Person>();
        tool.setE(new Person("huli",22));
        System.out.println("tool.getE() = " + tool.getE());
        show(new GenericsFunctionDemo());

    }

    public static  <W> void show(W e){
        //泛型方法。
        System.out.println(e.toString());
    }
}
