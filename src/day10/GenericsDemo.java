package day10;

import day09.ComparatorByNameDemo;
import day09.javaBean.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/*
泛型：
    JDK1.5出现的强制类型转换的安全机制。泛型技术是个编译器使用的技术，
确保了类型的安全。运行时，会把泛型去掉，生成的class文件中是不带泛型的，
这个称为泛型的擦除。在运行时，通过获取元素的类型进行转换侗族，不用使用
者再强制装换了。

    好处：
        1、将运行时期的问题ClassCastException转到了编译时期。
        2、避免了强制类型转换的麻烦

    使用时机：
        当操作的引用数据类型不确定的时候。就是使用<>。将要操作的
        引用数据类型传入即可，其实<>就是一个用于接收具体引用数据
        类型的参数范围。在程序中，只要用到了带有<>的类或者接口，就要明确
        传入的具体引用数据类型。

注意：
    1、在使用容器时，就应该明确这个容器中将要存储什么类型的元素。
    2、<>中只能是引用数据类型，假如传入的是4，则会自动装箱成Integer.

------------------------------------------------------------------------
1、泛型类
public class Tool<E>{
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

}

2、泛型方法
    public <E> void show(E e){
        System.out.println("e = " + e.toString());
    }
3、泛型接口
interface GenericsInterface<E>{
    public void show(E e);
}
4、泛型限定
    上限：? extends E 接收E类型或者E的子类型。
        存元素时使用上限。
        private static  void printCollection(Collection<? extends Person> al) {
            Iterator<? extends Person> iterator=al.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }
    下限：? super E 接收E类型或者E的父类型。
         取元素时使用下限。
 */
public class GenericsDemo {
    public static void main(String[] args) {
        //showGenerics_1();
        showGenerics_2();
    }

    private static void showGenerics_2() {
        //看到Tree就要想到元素的可比性，即树形结构会对元素进行排序。
        TreeSet<Person> treeSet=new TreeSet<Person>(new ComparatorByNameDemo());

        //Person类实现了Comparable接口，复写了compareTo方法，
        // 所以其元素，具有可比性，能够进行排序。
        treeSet.add(new Person("WangDongQiang",21));
        treeSet.add(new Person("Huli",22));
        treeSet.add(new Person("XieChao",23));
        treeSet.add(new Person("AnPeng",24));

        Iterator<Person> iterator=treeSet.iterator();
        while(iterator.hasNext()){
            Person person=iterator.next();
            System.out.println("Person = "+person.getName()+"::"+person.getAge());
        }

    }

    private static void showGenerics_1() {
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("abc");
        arrayList.add("bcd");
        //arrayList.add(4);//只能添加<>中的类型了。

        Iterator<String> iterator=arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator.next = " + iterator.next());
        }
    }
}
