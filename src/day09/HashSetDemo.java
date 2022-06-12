package day09;

import day09.javaBean.Person;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {

        //演示HashSet
        showHashSet();

        //往hashSet集合中存储Person对象，如果姓名和年龄相同，视为相同元素。
        //showStorageObject();
    }

    private static void showStorageObject() {
        HashSet hashSet=new HashSet();
        hashSet.add(new Person("anpeng1",21));
        hashSet.add(new Person("anpeng2",22));
        hashSet.add(new Person("anpeng3",23));
        hashSet.add(new Person("anpeng3",23));//两个不同的对象，但是相同的自定义元素
        //可以通过复写hashCode和equals方法来判断相同元素。
        hashSet.add(new Person("anpeng3",24));

        Iterator iterator=hashSet.iterator();
        while(iterator.hasNext()){
            Person person=(Person)iterator.next();
            System.out.println(person.getName()+"::"+person.getAge());
        }
    }

    private static void showHashSet() {
        HashSet hashSet=new HashSet();
        hashSet.add("anpeng");
        hashSet.add("huli");
        hashSet.add("love");
        hashSet.add("love");
        hashSet.add(new String("love"));//String类复写了hashCode和equals方法

        hashSet.add(5);//HashSet是用HashMap实现的，
        //HashMap中每个节点存储的是键值对，节点可以存储不同类型的元素。
        hashSet.add(new HashSetDemo());

        Iterator iterator=hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
