package day08;
/*
String类：
    * 字符串是一个特殊的对象。
    * 字符串一旦初始化就不可以改变。
    * 字符串对象存在于常量池中。
 */
public class StringDemo {
    public static void main(String[] args) {
        stringDemo1();
        System.out.println("-----");
        stringDemo2();
        System.out.println("-----");
    }

    /**
     * 演示字符串定义的第一种方式，并明确字符串常量池的特点。
     * 池中没有就建立，池中有，直接用。
     */
    private static void stringDemo1() {
        String s="abc";//创建0个或1个字符串对象在常量池中。
        //字符串缓冲区（常量池）中有与该字符串字面量相同的字符串常量对象，
        //则不用创建对象，直接指向该对象。若没有则创建。
        String s1="nba";

        System.out.println("abc的hash"+s.hashCode());
        s="nba";
        System.out.println("nba的hash"+s.hashCode());

        System.out.println("s = " + s);
        //打印s = nba，不是因为"abc"这个字符串对象
        //变成了"nba"，只是s这个字符串型的引用变量由
        // "abc"对象，指向了"nba"对象。"abc"对象本身没有改变。

        System.out.println(s==s1);//s和s1指向了常量池中同一个字符串常量池。
    }

    /**
     * 演示用字符串构造方法创建字符串。
     */
    private static void stringDemo2() {
        String s="abc";//创建0个或1个字符串对象在常量池中。
        //字符串缓冲区（常量池）中有与该字符串字面量相同的字符串常量对象，
        //则不用创建字符串对象，直接指向该对象。若没有则创建。

        String s1=new String("abc");//创建1个或2个字符串对象，
        //若常量池中有，则只需在堆内存中创建1个字符串对象副本，若常量池中没有，
        //则需要在常量池和堆内存中创建两个相同的字符串对象，只是地址不同而已。
        //注意：用构造器创建的字符串对象，返回的堆内存中对象的地址。

        //equals，toString等方法详情见day07.ObjectDemo.java
        System.out.println(s==s1);//false，比较的是两个字符串对象的地址。

        System.out.println(s.equals(s1));//String类重写了Object类中equals方法，
        //比较的是字符串内容，而不是比较字符串对象的地址。

        System.out.println(s.toString());//String类重写了Object类中toString方法，
        //打印的是字符串内容，而不是字符串对象类型和对象地址的hash值。
        System.out.println(new StringDemo());

        System.out.println("s中abc的hash"+s.hashCode());//String类重写了Object类中hashCode方法，
        //打印的是字符串内容的hash值，而不是字符串对象的hash值。
        System.out.println("s1中abc的hash"+s1.hashCode());
    }
}
