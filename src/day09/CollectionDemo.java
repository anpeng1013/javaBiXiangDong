package day09;

import java.util.ArrayList;
import java.util.Collection;

/*

集合的由来？
    对象用于封装特有数据，对象多了需要存储，如果对象的个数不确定，
    就使用集合容器进行存储。

    集合与数组的区别：
    1、集合是用于存储对象的容器，
        数组是用于存储基本数据类型和String类型的容器。
    2、集合的长度是可变的，数组长度不可变。
    3、集合中不可以存储基本数据类型,
        但是数组可以存储对象。

集合容器因为内部的数据结构不同，有多种容器，不断向上提取，就形成了集合框架。
    集合框架的顶层，Collection接口：
    Collection的常见功能：
    1、添加：
        boolean add(E e);添加一个数据
        boolean addAll(Collection coll);添加一堆数据
    2、删除：
        boolean remove(object obj)删除一个数据
        boolean removeAll(Collection coll);删除一堆数据，差集。
        void clear();清空集合对象中的所有数据，但该集合对象还在。
    3、判断：
        boolean contains(Object obj);
        boolean containsAll(Collection coll);
        boolean isEmpty();判断集合是否有元素。
    4、获取：
        int size();获取长度。
        Iterator iterator();取出元素的方式，返回一个能都取出该容器
        对象中元素的迭代器对象。该迭代器对象必须依赖于具体容器，因为一种容器
        的数据结构都不同。所以该迭代器对象时在容器中进行内部实现的。
        对于容器使用者而言，具体的实现不重要，只要通过容器获取到该实现的迭代器
        对象即可，也就是iterator方法。
        Iterator接口就是对所有的Collection容器进行元素取出的公共接口。
    5、其他：
        boolean retainAll(Collection coll);两个集合取交集。
        Object[] toArray();将集合转换成数组。

--------------------------------------------------------------------------------------------------------------------
Collection:
    |--List:列表，有序（存入和取出的顺序一致），元素都有索引（角标），元素可重复。
            可以完成对元素的增删改查。
    |--Set:集合(数学意思上的集合，即元素不可以重复），无序。
    |-Queue:队列（先-进先出，FIFO)。

---------------------------------------------------------------------------------------------------------------------
List:特有的常见方法：有一个共性特点，就是都可以操作角标。
1、添加
    void add(index,element);
    void add(index,collection);
2、删除
    Object remove(index);返回被删除的元素。
3、修改
    Object set(index,element);返回被修改的元素。
4、获取
    Object get(index);
    int indexOf(object);
    int lastIndexOf(object);
    List subList(from,to);包含头，不包含尾。

List:常用的子类。
    |--Vector：内部是数组数据结构，顺序存储，只能是同类型元素，是同步的。增删改查都很慢，开发基本不会使用了。
                从JDK1.0开始就具有，而List接口是1.2才有。
    |--ArrayList：内部是数组数据结构，只能是同类型元素，是不同步的。替代了Vector。改查的速度很快。
    |--LinkedList:内部是链表数据结构，可以是不同类型的元素，是不同步的。增删元素的速度很快。

------------------------------------------------------------------------------------------------------------------
Set：数学中抽象意义的集合，即元素不可以重复，且是无序的
        Set中的方法和Collection中的一致。
        |--HashSet:内部数据结构是哈希表，是不同步的。
            哈希表确定元素是否相同：
                1、判断的是两个元素的哈希值是否相同，
                    如果相同（因为哈希冲突），再判断两个元素的内容是否相同。
                2、判断哈希值相同，其实判断的是两个元素的hashCode方法计算的哈希值是否相同，
                    判断内容是否相同，用的是equals方法。
                注意：1、如果哈希值不同，是不需要判断equals方法的。
                      2、如果元素要存储到HashSet集合中，必须覆盖hashCode方法和equals方法。
                            因为判断两个元素是否相同是自定义的，比如在Person类中自定义年龄和姓名相同的是
                            同一个元素。若不覆盖hashCode方法和equals方法，可以两次添加new Person("anpeng",21)
                            元素，因为它们是两个不同的对象。而按照定义，这是两个相同元素，不能存在Set集合中。

        |--TreeSet:内部数据结构是红黑树，可以对Set集合中的元素进行排序，是不同步的。
                    判断元素唯一性的方式：就是根据比较方法compareTo的返回结果是否为0，
                    是0，就是相同元素，不存。
            TreeSet对元素进行排序的方式一：
                让元素自身具备比较功能，元素需要实现Comparable接口，覆盖compareTo方法。

        如果不要按照对象中具备的自然顺序进行排序，或者对象不具备自然顺序：
            TreeSet对元素进行排序的方式二：（常用）
                让TreeSet集合自身具备比较功能，定义一个类实现Comparator接口，覆盖compare方法。
                将该类对象作为参数传递给TreeSet集合的构造函数。

                注意;可以通过定义TreeSet的比较功能，让TreeSet实现有序（存取顺序一致），
                也可以实现逆序（存取顺序相反）。

------------------------------------------------------------------------------------------------------------------
集合使用技巧：
需要元素唯一吗？
需要：Set
    需要排序吗？
        需要：TreeSet
        不需要：HashSet
            但是希望存取顺序一致：LinkedHashSet
不需要：List
    需要频繁增删吗？
        需要：LinkedList
        不需要：ArrayList

    注意：后缀名就是该集合所属的体系，前缀名就是该集合的数据结构。
    1、看到array：就要想到数组，即查改快，有角标。
    2、看到linked：就要想到链表，即增删块，有addFirst+Last,get,removeFirst+Last方法。
    3、看到hash：就要想到哈希表，即唯一性，元素需要覆盖hashCode和equals方法。
    4、看到tree：就要想到红黑树，元素可以实现Comparable接口，集合可以实现Comparator接口
                    来实现元素的可比较性,可以进行排序。
    5、看到set:就要想到不可以重复。
        通常这些容器是不同步的。
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        Collection c2=new ArrayList();

        //演示对象数组
        //showObjectArray();

        //演示Collection的常用方法
        //showCollectionFunction_1(c1);
        showCollectionFunction_2(c1,c2);

    }



    public static void showCollectionFunction_2(Collection c1, Collection c2) {

        //给c1添加元素
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");
        //给c2添加元素
        c2.add("abc2");
        c2.add("abc6");
        c2.add("abc7");
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        //演示addAll(),返回值是boolean
        System.out.println("addAll:"+c1.addAll(c2));
        System.out.println("c1 = " + c1);

        //演示removeAll(),返回值boolean,求的是差集。
        System.out.println("removeAll:"+c1.removeAll(c2 ));
        System.out.println("c1 = " + c1);

        //演示containsAll(),判断是否包含，返回值boolean。
        Collection c3=new ArrayList();
        c3.add("abc1");
        c3.add("abc3");
        System.out.println("containsAll:"+c1.containsAll(c3));

        //演示retainAll(),返回值boolean,求的是交集
        System.out.println("retainAll:"+c1.retainAll(c3));
        System.out.println("c1 = " + c1);

    }

    public static void showCollectionFunction_1(Collection c1){
        //1、添加元素。add()
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        System.out.println(c1);
        //2、删除元素，remove
        c1.remove("abc2");//会改变集合长度。
        System.out.println(c1);
        //3、判断元素是否存在
        System.out.println(c1.contains("abc1"));
        System.out.println(c1.contains("abc2"));
        //4、清空集合
        c1.clear();
        System.out.println(c1);
    }

    public static void showObjectArray() {
        CollectionDemo c1=new CollectionDemo();
        CollectionDemo c2=new CollectionDemo();

        CollectionDemo[] collectionDemos={c1,c2};//存储对象的数组。
        System.out.println(c1);
        System.out.println(collectionDemos[0]);
    }
}
