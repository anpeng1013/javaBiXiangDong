package day07;
/*
进程：正在进行中的程序（直译）

线程：就是进程中一个负责程序执行的控制单元（执行路径）
      一个进程中可以多个执行路径，称之为多线程。开启多个线程是为了
      同时运行多部分代码。每个线程都有自己运行的内容，这个内容可以
      称为线程要执行的任务。 一个进程中至少要有一个线程。

多线程的好处:
    解决了程序中需要多个子功能同时运行的问题。
多线程的弊端：
    线程太多会导致效率的降低。

JVM启动时开启了多个线程，至少有两个线程可以分析出来
    1、执行main函数的线程。
        该线程的任务代码都定义在main函数中。
    2、负责垃圾回收的进程。
        在垃圾回收器中定义功能代码。


 */
class DemoGc{
    public void finalize(){//finalize是完成、定稿的意思。
        System.out.println("DemoGc Over...");
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        new DemoGc();
        new DemoGc();
        System.gc();//调用此方法，主动调用垃圾回收处理线程。
        new DemoGc();
        System.out.println("AnPeng");//java中垃圾回收线程在不确定的时间回收
        //堆内存中的垃圾。
    }
}
