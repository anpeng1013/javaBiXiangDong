package day10;

import day09.javaBean.Person;

public class GenericsClassDemo {
    public static void main(String[] args) {
        showGenericsClass();
    }

    //泛型类，泛型接口的定义在Tool.java
    private static void showGenericsClass() {
        Tool<Person> tool=new Tool<Person>();

        tool.setE(new Person("huli",22));
        System.out.println("tool.e = " + tool.getE().getName()+"::"+tool.getE().getAge() );
    }
}
