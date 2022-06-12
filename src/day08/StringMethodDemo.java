package day08;

public class StringMethodDemo {
    public static void main(String[] args) {
        /**
         * 按照面向对象的思想对字符串进行功能分类
         * "abcd"
         *
         * 1、获取：
         * 1.1 获取字符串中字符个数（长度）。
         *      int length();
         * 1.2 根据位置获取字符。
         *      char charAt(int index)
         * 1.3 根据字符获取在字符串中第一次出现的位置
         *      int indexOf(int char)：从前往后查找char第一次出现的位置。
         *      int indexOf(int char, int fromIndex):从指定位置开始查找char第一次出现的位置。
         *      int indexOf(String str)：获取子串str第一次出现的位置。
         *      int indexOf(String str, int fromIndex):从指定位置开始查找子串str第一次出现的位置。
         *
         *      int lastIndexOf(int char)：从后往前查找char第一次出现的位置。
         *      int lastIndexOf(int char, int fromIndex):从指定位置开始查找char第一次出现的位置。
         *      int lastIndexOf(String str)：获取子串str第一次出现的位置。
         *      int lastIndexOf(String str, int fromIndex):从指定位置开始查找子串str第一次出现的位置。
         * 1.4 获取子串。
         *      String substring(int begin, int endIndex)//endIndex会减一。
         *      String substring(int begin)
         *
         * 2.转换：
         * 2.1将字符串变成字符串数组（字符串的切割）
         *      String[] split(String regex)：涉及正则表达式。
         * 2.2将字符串变成字符数组。
         *      char[] toCharArray()
         * 2.3将字符串转换成字节数组。
         *      byte[] getBytes()
         * 2.4将字符串中的字母转换大小写。
         *      String toUpperCase();大写
         *      String toLowerCase();小写
         * 2.5将字符串的内容进行替换。
         *      String replace（char oldChar,char newChar);
         *      String replace(CharSequence old,CharSequence new):CharSequence是字符序列接口。
         * 2.6将字符串两端的空格去除
         *      String trim().
         * 2.7将基本数据类型转换成字符串类型。
         *      String valueOf()
         *
         * 3、判断
         * 3.1两个字符串内容是否相同？
         *      Boolean equals(Object obj)
         *      Boolean equalsIgnoreCase(String str);忽略大小写比较字符串内容
         * 3.2字符串中是否包含指定字符串？
         *      Boolean contains(String str);可以用indexOf（String str)代替。返回-1表示没有。
         * 3.3字符串是否以指定字符串开头，是否以指定字符串结尾。
         *      Boolean startsWith(String str)
         *      Boolean endsWith(String str)
         *
         * 4、比较
         * 4.1 按字典顺序比较两个字符串。
         *      int compareTo(String str)
         *      从两个字符串第一个字符串开始按字典顺序进行比较，其实就是比较每个字符的ASCII码的值，
         *      若遇到不相等的字符，则返回这两个字符ASCII码的差值，差值为正则表示原串比参数串大，
         *      差值为负则表示原串比参数字符串小，若每个字符都相等，则返回0。
         *
         * 5、操作字符串常量池
         *      String intern()
         *      用String s=new String("abc")会创建两个内容相同的对象，一个在堆中（副本），一个在字符串常量池中，
         *      但是，该方法返回的堆内存中对象副本的地址。而s.intern()会返回该字符串在常量池中的对象地址。
         */
        //stringMethodDemo_1();//获取
        //stringMethodDemo_2();//转换
        //stringMethodDemo_3();//判断
        //stringMethodDemo_4();
        stringMethodDemo_5();
    }

    private static void stringMethodDemo_5() {
        String s=new String("anpeng");
        String s1=s.intern();
        System.out.println(s==s1);
    }

    private static void stringMethodDemo_4() {
        System.out.println("a".compareTo("A"));
        System.out.println("abc".compareTo("afd"));
    }

    private static void stringMethodDemo_3() {
        String s="abc";
        System.out.println(s.equals("ABC"));
        System.out.println(s.equals("ABC".toLowerCase()));
        System.out.println(s.equalsIgnoreCase("ABC"));

        System.out.println(s.contains("cc"));

        String s1= "ArrayDemo.java";
        System.out.println(s1.startsWith("Array"));
        System.out.println(s1.endsWith("java"));
        System.out.println(s1.contains("Demo"));
    }

    private static void stringMethodDemo_2() {
        String s="张三，李四，王五";
        String[] arr=s.split("，");//注意中文逗号和英文逗号是不同的。
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] = " + arr[i]);
        }
        char[] chs=s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println("chs["+i+"] = " + chs[i]);
        }

        String s1="ab你";
        byte[] bytes=s1.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("bytes["+i+"] = " + bytes[i]);
        }

        System.out.println("anPENG".toUpperCase());
        System.out.println("ANpeng".toLowerCase());

        System.out.println("java".replace('a','o'));
        String s2="java";
        String s3=s2.replace('p','o');
        System.out.println(s2==s3);//true,没有替换成功，则指向原串。

        System.out.println("  anpeng  ".trim());

        System.out.println(String.valueOf(4)+1);
    }

    private static void stringMethodDemo_1() {
        String s="anpeng";
        System.out.println("length: " + s.length());//6
        System.out.println("char: "+s.charAt(2));//p
       // System.out.println("char: "+s.charAt(20));//java.lang.StringIndexOutOfBoundsException
        System.out.println("index: "+s.indexOf('n'));//1
        System.out.println("index: "+s.indexOf('k'));//-1 我们可以根据-1，来判断该子串或者字符是否存在。
        System.out.println("lastIndex: "+s.lastIndexOf('n'));//4
        System.out.println("subString: "+s.substring(2));
        System.out.println("subString: "+s.substring(0,6));//包含begin，不包含end。
    }
}
