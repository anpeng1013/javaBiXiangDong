package day09;

import java.util.Iterator;
import java.util.LinkedHashSet;

/*
HashSet的子类：
    LinkedHashSet：链表+哈希表，可保证有序读取的哈希表。
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        showLinkedHashSet();
    }

    private static void showLinkedHashSet() {
        LinkedHashSet linkedHashSet=new LinkedHashSet();

        linkedHashSet.add("anpeng");
        linkedHashSet.add("love");
        linkedHashSet.add("huli");
        linkedHashSet.add("forever");

        Iterator iterator=linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
