package day07;
/*
包（package）的作用：
    1、对类文件进行分类管理
    2、给类提供多层的命名空间
    3、包声明语句写在程序文件的第一行
    4、类名的全称是 包名.类名。在命令行使用java命令运行程序时，注意添加包名。
    5、包也是一种封装形式
    6、包与包之间的类进行访问，被访问包中的类必须是public修饰的，
        被访问包中的类的方法也必须是public修饰的。

四种权限 ：
             public     protected     default     private
同一个类中     ok            ok          ok          ok
同一个包中     ok            ok          ok
在其子类中     ok            ok
不同的包中     ok

import 语句用于导入其他包的中的类到当前文件中，该语句在包声明语句之后。
    注意：import只能导入其他包中的类，而不能导入其他包中的子包。

jar:java的压缩包
 */
public class PackageDemo {
    public static void main(String[] args) {
        System.out.println("hello package!");
    }
}
