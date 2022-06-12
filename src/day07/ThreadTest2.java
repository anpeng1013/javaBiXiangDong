package day07;
/*
需求：两个储户，每个都到银行存钱，每次存100，共存三次。
 */

/*
同步函数：用synchronized修饰的函数，可以解决线程安全问题。
 */
class Bank{
    private int sum;
    private Object object=new Object();
    public synchronized void add(int num){//同步函数
//        synchronized(object){//同步代码块，锁是object。
            sum+=num;
            try{Thread.sleep(10);}catch (InterruptedException e){}
            System.out.println(Thread.currentThread().getName()+"  sum = " + sum);
//        }
    }
}
class Customer implements Runnable{
    private Bank bank=new Bank();

    public void run(){
        //Bank bank=new Bank();//若在此处定义，则为局部变量，相当于是在两个银行存钱
        for (int i = 0; i < 3; i++) {
            bank.add(100);
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        Customer customer=new Customer();
        Thread thread=new Thread(customer);
        Thread thread1=new Thread(customer);
        thread.start();
        thread1.start();
    }
}
