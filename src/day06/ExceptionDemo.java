package day06;
/*
异常:是在运行时期发生的不正常情况。

在java中用类的形式对不正常的情况进行了描述和封装对象。描述不正常的类叫异常类。
    特点：以前将正常流程代码和问题处理代码相结合
          现在将正常流程代码和问题处理代码分离，提高阅读性。

    做法：1、不同的问题用不同的类进行具体描述，比如下标越界，空指针等等。
          2、将描述诸多问题的类的共性进行向上提取，形成了异常体系。
          3、异常体系：一般不可处理(Error)
                            error: 找不到或无法加载主类 hah
                            error: java.lang.OutOfMemoryError: Java heap space
                           特点：是由JVM抛出的严重性问题，
                           这种问题一般不针对性处理，直接修改程序。

                       可以处理(Exception)
              两者继承于Throwable类，异常都可以抛出
              Throwable:无论是error还是exception，发生问题都应该被抛出，让调用跟着知道并处理
                  该体系的特点就在于Throwable及其子类都具有可抛性。
                  可抛性是用两个关键字throws和throw来体现的,抛出异常后，后面的代码不会执行。

自定义异常：必须继承异常体系Exception或RuntimeException

throw和throws的区别
    1、throw使用在函数上。
       throw使用在函数内。
    2、throws是抛出的是异常类，可以抛出多个，用逗号隔开。
       throw抛出的是对象，只能抛出一个。

异常分类：
    1、编译时被检测异常：只要是Exception和其子类都是，除了特殊子类RuntimeException体系
        这种问题一旦出现，希望在编译时就进行检测，让这样的问题有对应的处理方式。
        这样的问题都可以针对性的处理。抛出之前必须声明。
    2、编译时不检测异常（运行时异常）：就是RuntimeException和其子类。
        这种问题的发生，无法让功能继续，运算无法进行，更多是因为调用者的原因导致的，或者引发了内部状态的改变导致的。
        那么这种问题一般不处理，直接编译通过，在运行时，让调用者调用时的程序强制停止，让调用者对代码进行修改。
        抛出之前可以不用声明。

 */

class FuShuIndexException extends Exception{//自定义异常
    FuShuIndexException(){}
    FuShuIndexException(String msg){
        super(msg);//使用父类的异常信息提示反馈方法。
    }
}
public class ExceptionDemo {
    public static void main(String[] args) throws FuShuIndexException{//主函数调用了声明异常的方法，且没有try catch，
        // 则主函数也必须声明异常

        int[] array=new int[3];
        // int[] array2=new int[1024*1024*400];//java.lang.OutOfMemoryError: Java heap space
        //method(array,3);//java.lang.ArrayIndexOutOfBoundsException: 数组角标越界了！
        //method(null,0);//若不先进行空指针判断，JVM会自动判断并抛出异常。
        method(array,-1);
    }
    public static void method(int[] arr,int index) throws FuShuIndexException{//会抛出异常的方法，必须声明异常。
        if(arr==null){//若不先进行空指针判断，JVM会自动判断并抛出异常。
            throw new NullPointerException("数组的引用不能为空！");
        }
        if(index>=arr.length){
            throw new ArrayIndexOutOfBoundsException("数组角标越界了！");
        }
        if(index<0){
            throw new FuShuIndexException("角标不能为负数！");//自定义异常
        }
        System.out.println(arr[index]);
    }
}
