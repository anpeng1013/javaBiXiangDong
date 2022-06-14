package day01;

public class HelloWorld {
    public static void main(String[] args) {
        int i=3;
        int a=(++i)+(++i)+(++i);
        System.out.println(a);
        System.out.println("anpeng love huli");
        System.out.println("Hello,World! test login in");
        System.out.println("test ssh");
        /*
        注意：
        set可以临时设置环境变量

        命令行运行;
        1、编译源文件：javac Demo.java
        2、执行class文件：java Demo。若源文件中有包名，即java源文件属于一个包内，
            则在执行时，应该在最外层包的上级目录下执行，并需要带包名，用.隔开。
            java PackagePath\PackageName.Demo
            java -cp "path" Demo   (其中-cp指定类文件路径，path为指定的类文件路径）
         */
    }
}
