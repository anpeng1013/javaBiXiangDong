package day09;

import day09.javaBean.Person;

import java.util.Comparator;

/**
 * 定义了一个根据Person类的name进行排序的比较器类。
 */
public class ComparatorByNameDemo implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person person1 = (Person) o1;
        Person person2 = (Person) o2;
        int temp = person1.getName().compareTo(person2.getName());
        return temp == 0 ? person1.getAge() - person2.getAge() : temp;
    }
}

/**
 * 定义一个使TreeSet可以有序的比较器类
 */
class ComparatorOrderTreeSet implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        return -1;//当返回负数时，为存取顺序相反，为正数时，存取顺序一致。
        /*
        TreeSet底层是二叉排序树，每次比较返回值为正整数时，表示新插入二叉排序树的元素
        比二叉排序树中的节点都大，结果都往右子树插入元素，最终二叉排序树退化成单链表，即有序的。
         */
    }
}