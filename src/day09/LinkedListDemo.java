package day09;

import java.util.Iterator;
import java.util.LinkedList;

/*
LinkedList: //每个节点可以时不同类型的元素。
    addFirst();//在表头插入元素
    addLast();//在表尾插入元素
    JDK1.6增加了如下的替代函数：
    offerFirst();//在表头插入元素
    offerLast();//在表尾插入元素

    getFirst();//获取表头元素但不移除，如果链表为空，抛出NoSuchElementException
    getLast();//获取表尾元素但不移除，如果链表为空，抛出NoSuchElementException
    JDK1.6增加了如下的替代函数：
    peekFirst();//获取表头元素但不移除，如果链表为空,返回null
    peekLast();//获取表尾元素但不移除，如果链表为空,返回null

    removeFirst();//获取表头元素并移除，如果链表为空，抛出NoSuchElementException
    removeLast();//获取表尾元素并移除，如果链表为空，抛出NoSuchElementException
    JDK1.6增加了一下的替代函数
    pollFirst();//获取表头元素并移除，如果链表为空,返回null
    pollLast();//获取表尾元素并移除，如果链表为空,返回null
 */
/*
面试题：
请使用一个LinkedList来模拟一个堆栈或者队列数据结构。
    堆栈(FILO)：先进后出 First In Last Out

    队列(FIFO)：先进先出First In First Out

    我们应该描述这样一个容器，给使用者提供一个容器对象完成这两种结构中的一种。
 */

class MyQueue{//队列类
    private LinkedList linkedList;
    MyQueue(){
        linkedList=new LinkedList();
    }
    //两端操作
    public void enqueue(Object object){

        linkedList.addLast(object);
    }
    public Object dequeue(){

        return linkedList.removeFirst();
    }

    public boolean isNull(){

        return linkedList.isEmpty();
    }
    public String toString(){

        return linkedList.toString();
    }
}
class MyStack{//堆栈类
    private LinkedList linkedList;
    MyStack(){
        linkedList=new LinkedList();
    }

    //一端操作
    public void push(Object object){

        linkedList.addFirst(object);
    }
    public Object pop(){

        return linkedList.removeFirst();
    }
    public boolean isNull(){

        return linkedList.isEmpty();
    }
    public String toString(){

        return linkedList.toString();
    }
}
public class LinkedListDemo {
    public static void main(String[] args) {
        //演示LinkedList的特有方法。
        //showLinkedListFunction();

        //演示用LinkedList实现的队列数据结构。
        showMyQueue();

        //演示用LinkedList实现的堆栈数据结构。
        showMyStack();
    }

    private static void showMyStack() {
        MyStack myStack=new MyStack();
        myStack.push("abc1");
        myStack.push("abc2");
        myStack.push("abc3");
        myStack.push("abc4");
        myStack.push(3);
        System.out.println("myStack = " + myStack);
        while (!myStack.isNull())
            System.out.println("myStack.top = " + myStack.pop());
        System.out.println("myStack = " + myStack);
    }


    private static void showMyQueue() {
        MyQueue myQueue=new MyQueue();
        myQueue.enqueue("abc1");
        myQueue.enqueue("abc2");
        myQueue.enqueue("abc3");
        myQueue.enqueue("abc4");
        System.out.println("myQueue = " + myQueue);
        while (!myQueue.isNull())
            System.out.println("myQueue.first = " + myQueue.dequeue());
        System.out.println("myQueue = " + myQueue);
    }

    private static void showLinkedListFunction() {
        LinkedList linkedList=new LinkedList();
        //在头部插入元素。
        linkedList.addFirst("abc1");
        linkedList.addFirst("abc2");
        linkedList.addFirst("abc3");
        linkedList.addFirst("abc4");

        //迭代元素。
        Iterator iterator=linkedList.iterator();
        while (iterator.hasNext())
            System.out.println("iterator.next = " + iterator.next());

         //获取链表头部元素
        System.out.println("linkedList = " + linkedList);//直接打印链表，是链表的字符串表现形式。
        System.out.println("linkedList.getFirst = " + linkedList.getFirst());
        System.out.println("linkedList.getFirst = " + linkedList.getFirst());

        //删除链表头部元素并返回。
        System.out.println("linkedList = " + linkedList);
        System.out.println("linkedList.getFirst = " + linkedList.removeFirst());
        System.out.println("linkedList.getFirst = " + linkedList.removeFirst());
        System.out.println("linkedList = " + linkedList);

    }
}
