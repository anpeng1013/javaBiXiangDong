package day05;

public class CarDemo{
    public static void main(String[] args) {
        Car car=new Car();//通过new关键字，创建一个Car的实例对象。
        //car就是一个Car类类型的引用变量，指向了Car类的对象。类类型的变量一定指向对象，要不就是null。

        /*
        匿名对象，没有名字的对象，也就是new 类名();定义对象的简写格式
       使用方法： Car c=mew Car();c.run();
                  new Car().run();
                  1、当对象方法仅进行一次调用的时候，就可以简化成匿名对象。
                  2、匿名对象可以作为实际参数进行传递。
                  3、匿名对象也是存储在堆中，但是创建运行结束后就会变垃圾，等待GC回收。

        new Car().num=5;的运行过程：
            1、先执行nen Car()在堆内存中创建对象，并默认初始化；
            2、再调用.num=5；进行赋值。

         */

        car.setNum(4);//设置乘客数
        car.setColor("red");//设置汽车颜色
        car.run();//汽车运行

        /*
        参数传递：
            1、基本数据类型参数传递。传递的是值
            2、引用数据类型参数传递，传递的地址。
         */
        Car car1=new Car();
        Car car2=car1;//car2和car1指向同一个对象。
        car1.setNum(5);
        car2.setColor("blue");
        car1.run();

        new Car().run();//匿名对象使用。
    }
}