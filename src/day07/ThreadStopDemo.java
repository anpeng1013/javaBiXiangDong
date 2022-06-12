package day07;
/*
停止线程的方法：
    1、stop、suspend方法，已过时。
    2、run方法结束。
        任务中都会有循环结构，只要控制住循环就可以结束任务。
        判断布尔型标记就可以控制循环。

    但是如果线程处于阻塞状态，无法读取标记，如何结束？
        可以使用interrupt()方法将线程从阻塞状态强制恢复到就绪状态，
        让线程具有竞争CPU资源的资格。但是强制动作会发生异常，记得处理。

    守护线程：也可以称为后台线程，当非守护线程都结束时，所有守护线程
        无论出于什么状态，都将自动结束。
 */
class ThreadStop implements Runnable{
    private boolean flag=true;
    public synchronized void run(){
        while(flag){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+"..."+e);
                flag=false;
            }
            System.out.println(Thread.currentThread().getName()+"...+++");
        }
    }
    public void setFlag(){
        flag=false;
    }
}
public class ThreadStopDemo {
    public static void main(String[] args) {
        ThreadStop threadStop=new ThreadStop();

        Thread thread1=new Thread(threadStop);
        Thread thread2=new Thread(threadStop);

        thread1.start();
        thread2.setDaemon(true);
        thread2.start();

        int num=1;
        while (true){
            if(++num==50){
                //threadStop.setFlag();
                thread1.interrupt();
                //thread2.interrupt();此处若不把该线程设置为守护线程，JVM不会结束。
                break;
            }
            System.out.println("main..."+num);
        }
        System.out.println("main over");
    }
}
