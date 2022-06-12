package day06;
/*
毕老师用电脑上课。
    问题领域中涉及两个对象。毕老师，电脑。

分析其中问题
    比如电脑蓝屏，冒烟。

异常的注意事项：
    1、子类在覆盖父类方法时，父类的方法如果抛出了异常，
        那么子类的方法只能抛出父类的异常或者该异常的子类。
        原因：多态的原理，若原来的代码中调用以父类对象为参数的方法，且catch
        中只能处理父类方法中抛出的异常，此时如果子类覆盖父类的方法，且子类抛出
        的异常不属于原来父类抛出的异常体系，此时若参数传进的子类对象，根据多态原理，
        需要父类的地方可以用子类替代，但是运行时调用的是子类覆盖的方法，该方法抛出的
        异常catch中处理不了。
    2、如果父类抛出多个异常，那么子类只能抛出父类异常的子集。
        简单说：子类覆盖父类只能抛出父类的异常或者子类或者子集。
        注意：如果父类的方法没有抛出异常，那么子类覆盖时绝对不能抛。就只能try。

 */

class Teacher{
    private String name;
    private Computer computer;
    Teacher(String name){
        this.name=name;
        computer=new Computer();
    }
    public void prelect()throws MaoYanException{//老师讲课
        try {
            computer.run();
            System.out.println(name+"讲课");
        }catch(LanPingException e){
            System.out.println(e.toString());
            computer.reset();
            prelect();
        }catch(MaoYanException e){
            System.out.println(e.toString());
            test();
            throw e;
        }
    }
    public void test(){
        System.out.println("大家练习。");
    }
}

class Computer{
    private int state=2;
    public void run()throws LanPingException,MaoYanException{
        if (state==1)
            throw new LanPingException("电脑冒烟了！");
        if (state==2)
            throw new MaoYanException("电脑冒烟了！");
        System.out.println("电脑运行...");
    }
    public void reset(){
        this.state=0;
        System.out.println("电脑重启");
    }
}

class LanPingException extends Exception{
    LanPingException(String msg){
        super(msg);
    }
}

class MaoYanException extends Exception{
    MaoYanException(String msg){
        super(msg);
    }
}
public class TryCatchTest {
    public static void main(String[] args) {
        Teacher teacher=new Teacher("毕老师");
        try{
            teacher.prelect();
        }catch (MaoYanException e){
            System.out.println("....");
        }
    }
}
