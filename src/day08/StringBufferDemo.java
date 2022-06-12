package day08;
/*
StringBuffer:
    就是字符串缓冲区，用于存储数据的容器。
        特点：
        1、长度是可变的。
        2、可存储不同类型的数据。
        3、最终要转成字符串进行使用。
        4、可以对字符串进行修改。
        5、线程安全，能够保证同步。

    容器具备的常用功能:
    1、添加
        StringBuffer append(data):尾部追加数据。
        StringBuffer insert(index，date);任意位置插入数据，index从0开始。
    2、删除
        StringBuffer delete(start,end):删除指定范围的数据，包含头，不包含尾。
        delete(0,sb.length());//相当去清空缓冲区。
    3、查找
        Char charAt(index);
        int indexOf(string);
        int lastIndexOf(string);
    4、修改
        StringBuffer replace(start,end ,string);//包含头，不包含尾。
        void setChat(index);
    5、设置长度
        void setLength(index);//改变缓冲区长度,若缩短长度，减少部分的内容会不见。
        void setLength（0，sb.length())相当于清空缓冲区。
    6、逆序
        StringBuffer reverse();

 */
public class StringBufferDemo {
    public static void main(String[] args) {
        bufferMethodDemo();
    }

    public static void bufferMethodDemo(){

        //创建缓冲区对象，默认初始容量为16个字符。
        StringBuffer sb=new StringBuffer();

        //尾部添加
        StringBuffer s1=sb.append(1124);
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
