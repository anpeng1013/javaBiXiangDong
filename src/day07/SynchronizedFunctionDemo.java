package day07;

/*
同步函数使用的锁是this。

同步代码块和同步函数对锁的操作是隐式的。

同步函数和同步代码块的区别：
    1、同步函数的锁是固定的this
    2、同步代码块的锁是任意的对象。
    3、开发中建议使用同步代码块，更加直观。
    4、静态同步函数的锁是所属类的字节码文件对象。
        可以用getClass方法获取，也可以用当前类名.class获取。
 */
class Ticket2 implements Runnable{
    //private int num=100;
    private static int num=100;//演示静态同步函数。
    boolean flag=true;

//    Object object=new Object();
    public void run(){
        //System.out.println("this:"+this.getClass());
        if(flag)
            while(true){
                synchronized(this.getClass()){//this.getClass()
                    if (num>0){
                        try{Thread.sleep(10);}catch (InterruptedException e){}
                        System.out.println(Thread.currentThread().getName()+"...object..."+num--);
                    }
                }
            }
        else
            while(true)
                show();
    }

   // public synchronized void show(){
    public static synchronized void show(){//演示静态同步函数的锁
        if (num>0){
            try{Thread.sleep(10);}catch (InterruptedException e){}
            System.out.println(Thread.currentThread().getName()+"...function..."+num--);
        }
    }
}
public class SynchronizedFunctionDemo {
    public static void main(String[] args) {
        Ticket2 ticket= new Ticket2();

        //System.out.println("ticket:"+ticket.getClass());
        Thread thread1 = new Thread(ticket, "thread1");
        Thread thread2 = new Thread(ticket, "thread2");

        thread1.start();
        try{Thread.sleep(10);}catch (InterruptedException e){}
        ticket.flag=false;
        thread2.start();

    }
}
