package day07;

class DemoJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().toString()+"..."+i);
            //toString方法打印当前执行线程的字符串表示形式
            // Thread[Thread-0,5,main]...0 名称，优先级（默认为5，最高为10，最低为1），线程组。

            //Thread.yield();//暂停当前执行线程，使当前线程处于就绪状态，yield是退让，屈服的意思。
            //调试该方法时，将主函数中的for循环和thread0的join方法注释掉
            // 但是两个线程并不会交替打印，因为有可能当前线程刚释放CPU后，马上又获得CPU。
        }
    }
}
public class ThreadFunctionDemo {
    public static void main(String[] args) throws InterruptedException{
        DemoJoin demoJoin=new DemoJoin();

        Thread thread0=new Thread(demoJoin);
        Thread thread1=new Thread(demoJoin);

        thread0.start();

        thread0.join();//thread0线程要申请加入进来，且运行。主线程调用到该方法时
        //放弃CPU并且阻塞自己，等待thread0运行完结束后再去竞争CPU。若该方法放在此处，
        //竞争CPU的线程只有Thread0，因为Thread1还没开启。
        //调试yield方法时，该方法需要注释掉。

        thread1.start();

        //thread0.join();//thread0线程要申请加入进来，且运行。主线程调用到该方法时
        //放弃CPU并且阻塞自己，等待thread0运行完结束后再去竞争CPU。该方法放在此处，
        //竞争CPU的线程为Thread0和Thread1
        //调试yield方法时，该方法需要注释掉。

        for (int i = 0; i < 50; i++) {//调试yield方法时，此循环需注释。
            System.out.println(Thread.currentThread()+"..."+i);
            //直接打印当前线程，默认调用的是toString方法。
        }

    }
}
