package day10;

import day09.javaBean.Person;
import day09.javaBean.Student;
import day09.javaBean.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericsFiniteDemo {
    public static void main(String[] args) {

        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("anpeng love");
        arrayList.add("huli");

        ArrayList<Person> arrayList1=new ArrayList<Person>();
        arrayList1.add(new Person("anepng",24));
        arrayList1.add(new Person("huli",24));

        ArrayList<Student> arrayList2=new ArrayList<Student>();

        arrayList2.add(new Student("huli",22));
        arrayList2.add(new Student("anpeng",24));

        ArrayList<Worker> arrayList3=new ArrayList<Worker>();
        arrayList3.add(new Worker("wangdongqiang",25));
        arrayList3.add(new Worker("xiechao",23));


        //printCollection(arrayList);//泛型限定，只能接收Person类或者其子类。
        printCollection(arrayList1);
        printCollection(arrayList2);
        printCollection(arrayList3);
    }

    private static  void printCollection(Collection<? extends Person> al) {
        Iterator<? extends Person> iterator=al.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

}
