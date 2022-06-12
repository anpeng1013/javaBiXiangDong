package day07;
/*
多生产者、多消费者问题：
    涉及的类有：产品、生产者、消费者

    用while循环加synchronized同步函数解决 多生产者和
多消费者的同步问题
    用notifyAll()解决多生产者和多消费者的死锁问题。
在对方所有线程阻塞，己方只有一个当前执行线程时，全部唤醒，若是对方被唤醒的线程抢到CPU执行，即可重置标记，
若是己方被唤醒的线程抢到CPU执行，则循环判断后继续阻塞，此时己方已全部阻塞，但是对方全部被唤醒就绪，可以被
CPU执行，从而重置标志位。
 */

//产品。
class Product{
    private String name;
    private int count=1;
    private boolean flag;

    public synchronized void set(String name){
        while(flag){//这里循环用来解决，线程每次被唤醒后需要重新判断标记。
            try{
                this.wait();
            }catch (InterruptedException e){
                //暂不处理。
            }
        }
        this.name=name+count;
        count++;
        System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
        flag=true;
        notifyAll();
    }

    public synchronized void out(){
        while(!flag){//这里循环用来解决，线程每次被唤醒后需要重新判断标记。
            try{
                this.wait();
            }catch (InterruptedException e){
                //暂不处理。
            }
        }
        System.out.println(Thread.currentThread().getName()+"..消费者...."+this.name);
        flag=false;
        notifyAll();
    }
}
class Producer implements Runnable{
    private Product product;
    Producer(Product product){
        this.product=product;
    }
    public void run(){
        while (true){
            product.set("烤鸭");
        }
    }
}

class Consumer implements Runnable{
    private Product product;
    Consumer(Product product){
        this.product=product;
    }
    public void run(){
        while (true){
            product.out();
        }
    }
}
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        //创建资源
        Product product=new Product();
        //创建任务
        Producer producer=new Producer(product);
        Consumer consumer=new Consumer(product);
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
