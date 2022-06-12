package day07;
import java.util.concurrent.locks.*;
/*
JDK1.5以后将同步和锁封装成了对象。并将操作锁的隐式方法定义
到了该对象中，将隐式动作变成了显式动作。

Lock接口：它的出现取代了同步函数和同步代码块。将同步的
    隐式操作变成了显式操作，同时更为灵活，可以在一个锁
    锁上加上多组监视器对象。
    lock()：获取锁。
    unlock()：释放锁，通常定义在finally代码块中。

Condition接口：它的出现替代了Object中wait notify notifyAll方法。
    将这些监视器方法进行了单独封装，变成了Condition对象，可以
    任意锁进行组合。
    await()：等同于Object中的wait方法
    signal()：等同于Object中的notify方法
    signalAll()：等同于Object中的notifyAll方法

 */
//产品。
class Product1{
    private String name;
    private int count=1;
    private boolean flag;

    //创建一个锁对象
    Lock lock=new ReentrantLock();
    //通过已有的锁获取该锁上的监视器对象。
//    Condition condition=lock.newCondition();

    //通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者
    Condition producer_con=lock.newCondition();
    Condition consumer_con=lock.newCondition();

    public  void set(String name){
        lock.lock();//获取锁
        try{
            while(flag){//这里循环用来解决，线程每次被唤醒后需要重新判断标记。
                try{
                    //condition.await();//用JDK1.5中的lock实现之前的synchronized
                    producer_con.await();
                }catch (InterruptedException e){
                    //暂不处理。
                }
            }
            this.name=name+count;
            count++;
            System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
            flag=true;
            //condition.signalAll();
            consumer_con.signal();//唤醒消费者中任意一个。
        }
        finally {
            lock.unlock(); //释放锁。
        }
    }

    public void out(){
        lock.lock();//获取锁
        try{
            while(!flag){//这里循环用来解决，线程每次被唤醒后需要重新判断标记。
                try{
                    //condition.await();
                    consumer_con.await();
                }catch (InterruptedException e){
                    //暂不处理。
                }
            }
            System.out.println(Thread.currentThread().getName()+"..消费者...."+this.name);
            flag=false;
            //condition.signalAll();
            producer_con.signal();//唤醒任意一个生产者来生产。
        }
        finally {
            lock.unlock();//释放锁
        }
    }
}
class Producer1 implements Runnable{
    private Product1 product;
    Producer1(Product1 product){
        this.product=product;
    }
    public void run(){
        while (true){
            product.set("烤鸭");
        }
    }
}

class Consumer1 implements Runnable{
    private Product1 product;
    Consumer1(Product1 product){
        this.product=product;
    }
    public void run(){
        while (true){
            product.out();
        }
    }
}
public class ProducerConsumerDemo2 {
    public static void main(String[] args) {
        //创建资源
        Product1 product=new Product1();
        //创建任务
        Producer1 producer=new Producer1(product);
        Consumer1 consumer=new Consumer1(product);
        //创建线程
        Thread thread0=new Thread(producer);
        Thread thread1=new Thread(producer);
        Thread thread2=new Thread(consumer);
        Thread thread3=new Thread(consumer);
        //开启线程
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
