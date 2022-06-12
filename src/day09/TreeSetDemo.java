package day09;

import day09.javaBean.Person;

import java.util.Iterator;
import java.util.TreeSet;

//看到Tree就要想到元素的可比性，即树形结构会对元素进行排序。

public class TreeSetDemo {
    public static void main(String[] args) {
        //演示TreeSet存储字符串对象。
        //showTreeSet_1();

        //演示TreeSet存储自定义对象,该对象具备比较功能。
        //showTreeSet_2();

        //演示TreeSet自定义的比较器通过姓名来排序 ，存储自定义对象，优先使用比较器。
        //showTreeSet_3();

        //演示TreeSet实现有序和逆序。
        showTreeSet_4();

    }

    private static void showTreeSet_4() {
        //看到Tree就要想到元素的可比性，即树形结构会对元素进行排序。
        TreeSet treeSet=new TreeSet(new ComparatorOrderTreeSet());//利用给TreeSet的构造函数传入一个比较器参数，
                                                                //使该集合具有比较功能。

        treeSet.add(new Person("AnPeng",24));
        //Person类实现了Comparable接口，复写了compareTo方法，
        // 所以其元素，具有可比性，能够进行排序。
        treeSet.add(new Person("HuLi",22));
        treeSet.add(new Person("XieChao",23));
        treeSet.add(new Person("WangDongQiang",25));

        Iterator iterator=treeSet.iterator();
        while(iterator.hasNext()){
            Person person=(Person)iterator.next();
            System.out.println("person = " + person.getName()+"::"+person.getAge());
        }
    }

    private static void showTreeSet_3() {
        TreeSet treeSet=new TreeSet(new ComparatorByNameDemo());
        treeSet.add(new Person("AnPeng",24));
        treeSet.add(new Person("HuLi",22));
        treeSet.add(new Person("XieChao",23));
        treeSet.add(new Person("WangDongQiang",25));

        Iterator iterator=treeSet.iterator();
        while(iterator.hasNext()){
            Person person=(Person)iterator.next();
            System.out.println("person = " + person.getName()+"::"+person.getAge());
        }
    }

    private static void showTreeSet_2() {
        TreeSet treeSet=new TreeSet();
        treeSet.add(new Person("AnPeng",24));
        treeSet.add(new Person("HuLi",22));
        treeSet.add(new Person("XieChao",23));
        treeSet.add(new Person("WangDongQiang",24));

        Iterator iterator=treeSet.iterator();
        while(iterator.hasNext()){
            Person person=(Person)iterator.next();
            System.out.println("person = " + person.getName()+"::"+person.getAge());
        }
    }

    private static void showTreeSet_1() {
        TreeSet treeSet=new TreeSet();

        treeSet.add("anpeng");
        treeSet.add("love");
        treeSet.add("huli");

        Iterator iterator=treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
