package day09;

import day09.javaBean.Person;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList arrayList=new ArrayList();
        arrayList.add(new Person("anpeng1",21));//add(Object object),向上转型。
        arrayList.add(new Person("anpeng2",22));
        arrayList.add(new Person("anpeng3",23));
        arrayList.add(new Person("anpeng4",24));
        //arrayList.add(new ArrayListDemo());//java.lang.ClassCastException: day09.ArrayListDemo cannot be cast to day09.javaBean.Person
        //arrayList.add(5);//java.lang.ClassCastException: java.lang.Integer cannot be cast to day09.javaBean.Person

        Iterator iterator=arrayList.iterator();
        while (iterator.hasNext()){
//            System.out.println("name=" + ((Person)iterator.next()).getName()
//                    +" age=" + ((Person)iterator.next()).getAge());//向下转型。
//                //调用两次next，会打印出错，因为next指针会后移。
            Person person= (Person) iterator.next();
            System.out.println(person.getName()+"::"+person.getAge());
        }
        System.out.println(arrayList.get(0));//通过get方法可以使用数组下标访问元素,不能直接使用中括号。

    }
}
