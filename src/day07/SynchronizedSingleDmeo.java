package day07;
/*
多线程下的单例模式：

 */

//饿汉式：类一加载就有对象。
class Single{
    private static final Single single=new Single();
    private Single(){}
    public static Single getInstance(){
        return single;
    }
}

//懒汉式：需要的时候才创建对象。
//需要如下的双重判断和加锁机制才能保证多线程下的安全问题。
class Single2{
    private static Single2 single=null;
    private Single2(){}

    public static Single2 getSingle() {
        if(single==null){//判断锁的开销可以降低。
            synchronized(Single.class){//静态函数中不存在this。
                if(single==null)//存在多线程安全问题，对该代码块加锁.
                    //若对函数加锁，则判断锁的开销大，
                    single=new Single2();
            }
        }
        return single;
    }
}
public class SynchronizedSingleDmeo {
}
