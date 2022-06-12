package day07;
/*
创建线程的方式：
    1、继承Thread类。
        因为需要继承Thread类，且java中不支持多继承，故只适用于没有直接父类的类。
        步骤：1、定义一个类继承Thread类。
              2、覆盖Thread类的run方法。
              3、直接创建Thread的子类对象，创建线程。
              4、调用start方法开启线程并调用线程的任务run方法执行。
        可以通过Thread的getName方法获取线程子类对象的名称 Thread-编号（从0开始）。
            使用Thread.currentThread().getName()获取当前执行线程名称。
        主线程的名称是main，创建新线程时，可以在构造函数使用super（name）的方法指定新线程的名称。

    2、实现Runnable接口
        步骤：1、定义类实现Runnable接口
              2、覆盖接口中的run方法，将线程的任务代码封装在run方法中
              3、通过Thread类创建线程对象，并将实现Runnable接口的子类对象作为Thread类的构造函数
                  的参数进行传递，创建线程Thread对象。为什么？因为线程的任务都封装在Runnable接口子类
                  对象的run方法中，所以要在线程对象创建时就必须明确要执行的任务。
              4、调用线程对象的start方法开启线程。

          实现Runnable接口的好处
            1、将线程的任务从线程的子类中分离出来，进行了单独的封装。
                按照面向对象的思想将任务封装成对象。
            2、避免了java单继承的局限性。
            这种创建线程的方式较为常用。
 */
class Demo1 extends Thread{
    private String name;
    Demo1(String name){
        super(name);//指定线程名。
        this.name=name;
    }
    public void run(){
        show();
    }
    public void show(){
        for (int i = 0; i < 10; i++) {
/*            for (int j = -99999999; j <999999999 ; j++) {
                for (int k = -999999999; k <999999999 ; k++) {
                }
            }//延时处理。*/
            System.out.println(name+"...i = " + i+" current thread name="+Thread.currentThread().getName());
        }
    }
}

class Demo2 extends Fu implements Runnable {//准备扩展Demo2类的功能，让其中的内容可以作为线程的任务执行。
            //通过实现Runnable接口的形式完成。
    public void run(){
        show();
    }
    public void show(){
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"..."+i);
        }
    }
}
class Fu{}
public class ThreadDemo2 {
    public static void main(String[] args) {
        /*
        创建线程的的目的是为了开启一条执行路径，去运行指定的代码和
        代码实现同时运行。而运行的指定代码就是这个执行路径的任务。

        JVM创建的主线程的任务都定义在了主函数中。
        而自定义的线程的任务在哪儿呢？
            Thread类用于描述线程，线程是需要执行任务的。所以Thread类是对任务的描述。
            这个任务就通过Thread类中的run方法来体现。也就是说，run方法就是封装自定义
            线程运行任务的函数。
            run方法中定义的就是线程要运行的任务代码。

        开启多线程是为了运行指定代码，所以只有继承Thread类并复写run方法。
        将运行的代码定义在run方法中即可。
         */
        Demo1 demo1=new Demo1("anpeng");
        Demo1 demo2=new Demo1("huli");
//        demo1.show();
//        demo2.show();
//        demo1.run();//这种直接调用run的方式，和上面一样，达不到多线程。
//        demo2.run();//这种直接调用run的方式，调用该方法的是main主线程。
//        demo1.start();//开启线程，JVM开启一个新的新线程并调用run方法
//        demo2.start();//开启线程，调用run方法的是一个新的线程。
//        System.out.println("over..."+" current thread name="+Thread.currentThread().getName());

        Demo2 demo21=new Demo2();
        Thread thread=new Thread(demo21);
        Thread thread1=new Thread(demo21);
        thread.start();
        thread1.start();
    }
}
