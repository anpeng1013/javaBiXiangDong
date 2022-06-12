package day05;


/*
设计模式：对问题行之有效的解决方案。其实它是一种思想。
1、单例设计模式。
    解决的问题：可以保证一个类在内存中的对象唯一性。
  比如对于多个程序使用同一配置信息对象时，就需要保证该对象的唯一性。

  如何保证对象唯一性呢？
  1、不允许其他程序用new创建该类对象。
  2、在该类中创建一个本类对象实例。
  3、对外提供一个方法让其他程序可以获取该对象实例。
  步骤：1、私有化该类构造函数。
        2、通过new在本类中创建一个私有的本类对象。
        3、定义一个公有方法，将创建的对象返回。
 */
class Single{//单例模式的饿汉式,开发中常用的形式。
    private static Single single=new Single();//类加载，single对象就建立
    private Single(){}//私有化构造函数
    public static Single getInstance(){
        return single;

    }
    //以上三个步骤保证对象的唯一性,若不加这三个步骤，
    // 则主函数中s1,s2的num值不相同。
    private int num;
    public int getNum(){
        return this.num;

    }
    public void setNum(int num){
        this.num=num;

    }
}
class Single2{//单例模式的懒汉式，也叫做延迟加载形式。
    //类加载进来，没有对象，只有调用了getInstance方法时，才会创建对象。
    //懒汉式在多线程的情况下存在安全隐患，保证不了对象的唯一性
    private static Single2 single2=null;
    private Single2(){}//私有化构造函数
    public static Single2 getInstance(){
        if(single2==null)
            single2=new Single2();
        return single2;
    }

    //以上三个步骤保证对象的唯一性,若不加这三个步骤，
    // 则主函数中s1,s2的num值不相同。
    private int num;
    public int getNum(){
        return this.num;

    }

    public void setNum(int num){
        this.num=num;

    }
}
public class SingleDemo {
    public static void main(String[] args) {
        Single s1=Single.getInstance();
        Single s2=Single.getInstance();
        System.out.println(s1==s2);
        s1.setNum(10);
        s2.setNum(20);
        System.out.println(s1.getNum());
        System.out.println(s2.getNum());
    }

}
