package day08;

/*
基本数据类型包装类：
    为了方便操作基本数据类型的值，将其封装成了对象，在对象中
    定义了属性和行为，丰富了该数据的操作。用于描述该基本数据对象的
    类就称为基本数据类型包装类。

byte    --> Byte
short   --> Short
int     --> Integer
long    --> Long
float   --> Float
double  --> Double
char    --> Character
boolean --> Boolean

自动装箱：当基本数据类型值，赋给了引用类型变量，会自动装箱。
            Integer integer = 3;
自动拆箱：当基本数据类型包装类变量与 基本数据类型值 运算时，会自动拆箱
            int x = integer + 8;


该包装对象主要用于基本类型和字符串之间的转换。
基本数据类型--->字符串
    1、基本类型+""
    2、用String类中的静态方法valueOf(基本数据类型值)，
        valueOf调用的是Integer中复写的静态方法toString。

字符串-->基本数据类型
    1、使用包装类中的静态方法xxx parseXxx("xxx类型的字符串")。
        int parseInt("123");
        long parseLong("123L");
        float parseFloat("13.14");
        只有character没有parse方法。parse 解析的意思。
    2、如果字符串被Integer进行对象的封装。
        可使用另一个非静态的方法，intValue();将一个Integer对象
        转成基本数据类型。

 */
public class WrapperDemo {//wrapper 包装、封装的意思

    public static void main(String[] args) {
        System.out.println("基本数据类型包装类的基本使用：");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("------------------------------------------");

        System.out.println("基本数据类型-->字符串");
        System.out.println(123 + "1");//1231

        System.out.println(String.valueOf(123) + 1);//1231
        System.out.println("-------------------------------------------");

        System.out.println("字符串-->基本数据类型");
        int x = Integer.parseInt("123");
        Integer integer = new Integer("123");
        System.out.println(x + 1);//124，转成了整数
        System.out.println(integer);//直接打印对象，integer参数中包含该对象的value值为123，
        // 调用的String类中的valueOf(integer)最终调用的是复写toString(integer.value)，
        //返回的是该Integer对象的字面值的字符串表现形式。
        System.out.println(integer.toString() + 1);

        System.out.println(new Integer("1234").intValue() + 1);
        System.out.println("-------------------------------------------");

        System.out.println("十进制-->其他进制：");
        System.out.println(Integer.toHexString(60));
        System.out.println(Integer.toOctalString(60));
        System.out.println(Integer.toBinaryString(60));
        System.out.println("-------------------------------------------");

        System.out.println("其他进制-->十进制");
        System.out.println(Integer.parseInt(Integer.toBinaryString(60), 2));
        //Integer.toBinaryString(60)=="111100",radix 是基数的意思。
        System.out.println("-------------------------------------------");

        System.out.println("基本数据类型对象的比较");
        Integer a = new Integer("1024");
        Integer b = new Integer(1024);
        System.out.println(a == b);//==比较的是两个对象的地址
        System.out.println(a.equals(b));//Integer中的equals方法被复写了，
        //比较的是两个对象的value值。
        System.out.println("-------------------------------------------");

        System.out.println("基本数据类型的自动装箱、拆箱");
        Integer integer1 = 127;//自动装箱
        Integer integer2 = 127;
        System.out.println(integer1==integer2);

        Integer integer3=-128;
        Integer integer4=-128;
        System.out.println(integer3==integer4);

        Integer integer5=128;
        Integer integer6=128;
        System.out.println(integer5==integer6);
        Integer integer7=-129;
        Integer integer8=-129;
        System.out.println(integer7==integer8);
        /*
        自动装箱时需注意：
            在jdk1.5以后，如果装箱的是一个字节，那么该数据会被共享
            不会开辟新的对象空间。
         */

        System.out.println(++integer1);//自动拆箱。
        System.out.println(integer1 + 4);
        /*
        自动拆箱时需注意：
            需要进行空引用检测，因为若上面的integer1为null，
            在进行integer1+4时会发生空指针异常。
         */
        System.out.println("-------------------------------------------");
    }
}
