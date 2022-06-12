package day09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        //showFunction(list);
        showConCurrentModificationException();
    }

    private static void showConCurrentModificationException() {
        List list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");

     /* Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            Object object=iterator.next();//java.util.ConcurrentModificationException
            //在迭代过程中国，不要使用列表对象操作元素，容易出现异常，可以使用
            //Iterator接口中的子接口ListIterator来完成在迭代中对元素进行修改操作。
            if (object.equals("abc2"))
                list.add("abc9");
            else
                System.out.println("next:"+object);
        }
        System.out.println("list = " + list);
        */

        ListIterator iterator = list.listIterator();//获取列表迭代器对象。
        //它可以实现在迭代过程中完成对元素的增删改查。
        //注意：只要list对象具备该迭代功能。
        System.out.println("list = " + list);
        while (iterator.hasNext()){
            Object object = iterator.next();
            if (object.equals("abc2"))
                iterator.set("abc9");
            else
                System.out.println("next:" + object);
        }
        System.out.println("hasNext:"+iterator.hasNext());//hasNext：从前往后
        System.out.println("hasPrevious:"+iterator.hasPrevious());//hasPrevious:从后往前
        while (iterator.hasPrevious())
            System.out.println("previous:"+iterator.previous());
        System.out.println("list = "+list);
    }



    private static void showFunction(List list) {
        //添加元素
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        System.out.println("list = " + list);
        //插入元素
        list.add(1,"abc9");
        System.out.println("list = " + list);
        //删除元素
        System.out.println("remove:"+list.remove(1));
        System.out.println("list = " + list);
        //修改元素
        System.out.println("set:"+list.set(1,"abc8"));
        System.out.println("list = " + list);
        //使用迭代器遍历取出列表元素
        Iterator iterator=list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next()+" ");
        System.out.println();
        //使用List的特有方法遍历取出列表元素。
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();


    }
}
