package day07;

class Test implements Runnable{
    private boolean flag;

    Test(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            synchronized (MyLock.lock_a) {
                System.out.println(Thread.currentThread().getName()+"..,if code lock a...");
                synchronized (MyLock.lock_b) {
                    System.out.println(Thread.currentThread().getName()+"...if code lock b...");
                }
            }
        } else {
            synchronized (MyLock.lock_b) {
                System.out.println(Thread.currentThread().getName()+"...else code lock b...");
                synchronized (MyLock.lock_a) {
                    System.out.println(Thread.currentThread().getName()+"...else code lock b...");
                }
            }
        }
    }
}

class MyLock{
    public static final Object lock_a=new Object();
    public static final Object lock_b=new Object();
}
public class DeadLockTest {
    public static void main(String[] args) {
        Test a=new Test(true);
        Test b=new Test(false);

        Thread t1=new Thread(a);
        Thread t2=new Thread(b);

        t1.start();
        t2.start();
    }
}
