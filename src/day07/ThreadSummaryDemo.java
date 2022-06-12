package day07;
/*
面试题：
class Test implements Runnable{
    public void run(Thread thread) {

    }
}
上面代码是否错误？若有错，错误发生在哪一行？
    代码错误，发生在第一行，没有实现Runnable接口中的run()方法
    该类应该是抽象类，需要被abstract关键字修饰。

new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("runnable run");
        }
    }){
        @Override
        public void run() {
            //super.run();//默认调用。
            System.out.println("subThread run");
        }
    }.start();
   执行顺序是runnable run 、subThread run.
 */

public class ThreadSummaryDemo {
    public static void main(String[] args) {

        new Thread(){//匿名内部类，Thread的子类对象。
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {//这里范围大一点，
                    // 否则CPU运行过快，看不出多线程竞争CPU的效果
                    System.out.println(Thread.currentThread().getName()+"... " + i);
                }
            }
        }.start();

        Runnable runnable=new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {//这里范围大一点，
                    // 否则CPU运行过快，看不出多线程竞争CPU的效果
                    System.out.println(Thread.currentThread().getName()+"... " + i);
                }
            }
        };
        new Thread(runnable).start();

        for (int i = 0; i < 50; i++) {//这里范围大一点，
            // 否则CPU运行过快，看不出多线程竞争CPU的效果
            System.out.println(Thread.currentThread().getName()+"... " + i);
        }
    }
}
