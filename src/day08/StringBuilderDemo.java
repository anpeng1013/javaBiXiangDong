package day08;
/*
    jdk 1.5以后出现了功能和StringBuilder一样的StringBuilder
    不同的是：
    StringBuf是线程同步的，通常用于多线程，效率降低。
    StringBuilder是线程不同步的，所以速度更快，在单线程总优先使用。

    JDK的升级：
    1、简化书写。
    2、提高效率。
    3、增加安全性。
 */
public class StringBuilderDemo {
    public static void main(String[] args) {

    }
    public static void bufferMethodDemo(){

        //创建缓冲区对象，默认初始容量为16个字符。
        StringBuilder sb=new StringBuilder();

        //尾部添加
        StringBuilder s1=sb.append(1124);
        System.out.println(s1==sb);
        s1.append(" anpeng").append("huli ");

        //指定位置插入
        s1.insert(11," love ");
        s1.append(true);
        System.out.println(sb);//s1和sb指向同一个缓冲区对象。

        //指定范围删除
        s1.delete(0,5);//包含头，不包含尾。
        System.out.println(s1);

        //清空缓冲区,但是缓冲区还在。
        s1.delete(0,s1.length());
        System.out.println(sb);//打印为空，s1和sb指向同一个缓冲区对象。

        //查找
        sb.append("anpeng love huli");
        System.out.println(sb.charAt(0));
        System.out.println(sb.indexOf("huli"));//12
        System.out.println(s1.lastIndexOf("n"));//s1和sb指向同一个缓冲区对象。

        //替换
        sb.replace(0,2,"An");//包含头，不包含尾。
        sb.setCharAt(12,'H');
        System.out.println(sb);

        //设置长度
        sb.setLength(6);
        System.out.println("s1 = " + s1);
        System.out.println("length:"+sb.length());
        sb.setLength(16);
        System.out.println("s1 = " + s1);
        System.out.println("length:"+sb.length());

        //逆序
        sb.reverse();
        System.out.println(s1);
    }
}
