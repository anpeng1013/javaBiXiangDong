package day09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        //给c1添加元素
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");

        //直接打印集合对象，打印的是集合对象的字符串表现形式。
        System.out.println("c1 = " + c1);

        //使用Collection中的iterator方法。
        //调用集合对象中的迭代器方法，是为了获得集合中的迭代器对象。

//        Iterator iterator=c1.iterator();
//        while (iterator.hasNext())//while循环结束后，迭代器的指针
//            //指向了集合对象最后一个元素的后面，故而全部元素迭代一次后不能再迭代取出。
//            System.out.println(iterator.next());
//        System.out.println(iterator.next());//java.util.NoSuchElementException

        for (Iterator it=c1.iterator();it.hasNext();){//开发中一般采用for迭代集合对象中的元素。
            System.out.println(it.next());
        }
    }
}
