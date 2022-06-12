package day10;

import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) {
        /*
        Runtime：没有构造方法摘要，说明该类不可以创建对象。
        又发现还有非静态的方法，说明该类应该提供静态的返回该类对象的方法。
        而且只有一个，说明Runtime类使用了单例设计模式。
         */
        showRuntime();
    }

    private static void showRuntime()  {
        Runtime runtime=Runtime.getRuntime();
        try {
            //用Runtime 对象的exec方法去执行可执行程序。
            runtime.exec("F:\\QQinstall\\Bin\\QQ.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
