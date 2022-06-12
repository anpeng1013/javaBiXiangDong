package day07;
/*
需求：卖票。多线程实现


线程安全问题产生的原因：
    1、多个线程在操作共享的数据。
    2、操作共享数据的代码有多条，且修改了共享数据的值。
    解决思路：
        就是将多条操作共享数据的线程代码封装起来，当有线程在
    执行这些代码的时候，其他线程不可以执行该代码，即线程上锁。

在java中，用同步代码块来解决多线程安全问题。
    格式：
    synchronized(对象){//此处对象常用 Object object=new Object();
        需要被同步的代码；
    }

同步的好处：解决了多线程的安全问题。
同步的弊端：相对降低了效率，因为同步外的线程都会判断同步锁。
同步的前提：必须有多个线程并发执行，且使用同一个同步锁。
 */
class Ticket extends Thread{
    private static int num=100;//最好不要使用静态。
    Ticket(String name){
        super(name);//指定线程名字
    }
    public void run(){
        sale();
    }
    public void sale(){
        while (num>0){
            System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
        }
    }
}
class Ticket1 implements Runnable{
    private int num=100;
    Object object=new Object();
    public void run(){
        //Object object=new Object();//不能放在此处作局部变量，否则每个
        //线程开启的run方法都有自己的同步锁对象，导致不是同一个同步锁。
        while (true){
            synchronized (object){//使用锁之后，num不会出现0或者负数的情况。
                if (num>0){
//                    for (int i = -999999999; i <999999999 ; i++) {
//                        for (int j = -999999999; j <999999999 ; j++) {
//                            //延时处理，为了查看当num=1时的线程安全问题。
//                            /* 本该只打印1，结果打印了0甚至是负数。线程不安全。
//                                thread1...sale...1
//                                thread2...sale...0
//                                thread3...sale...-1
//                                thread4...sale...-2
//                             */
//                        }
//                    }
                    //也可以使用Thread的静态函数sleep（int num）来实现延时，num指的是当前线程暂停的毫秒数。
                    //sleep函数中抛出了中断异常，故要么声明，要捕捉catch。但是该子类实现的Runnable接口，
                    //该接口没有声明异常，所以只能catch，不能声明。
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){}
                    System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
                }
            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        //使用继承Thread类的方法，同时票数使用静态才能实现。
//        Ticket ticket1=new Ticket("ticket1");
//        Ticket ticket2=new Ticket("ticket2");
//        Ticket ticket3=new Ticket("ticket3");
//        Ticket ticket4=new Ticket("ticket4");
//        ticket1.start();//每个线程对象只能开启一次，
//        // 若同时开启会抛出非法线程状态异常java.lang.IllegalThreadStateException
//        ticket2.start();
//        ticket3.start();
//        ticket4.start();

        //使用实现Runnable接口的方法。
        Ticket1 ticket11=new Ticket1();//创建一个线程任务对象。
        Thread thread1=new Thread(ticket11,"thread1");
        Thread thread2=new Thread(ticket11,"thread2");
        Thread thread3=new Thread(ticket11,"thread3");
        Thread thread4=new Thread(ticket11,"thread4");
        thread1.start();//这里四个thread最终操作的是堆内存中同一个线程对象的num。
        thread2.start();//这里四个thread最终操作的是堆内存中同一个线程对象的num。
        thread3.start();//这里四个thread最终操作的是堆内存中同一个线程对象的num。
        thread4.start();//这里四个thread最终操作的是堆内存中同一个线程对象的num。
    }
}
