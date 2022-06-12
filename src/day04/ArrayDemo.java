package day04;

public class ArrayDemo {
    /*
    数组：
        概念：同一类型数据的集合，允许重复，其实，数组就是一个容器（装东西的地方）
        好处：可以自动给数组中的元素从0开始编号，方便操作这些元素
        特点：有序、可重复、可随机访问、默认初始化值为0（int）、null（引用）、0.0（float）、false（Boolean）。
        内存：数组变量存储在栈中，栈中存储的是地址，数组实体存储在堆内存中。数组是引用类型（其实就是指针），当数组不指派任何对象时，用null赋值。
        JVM内存：
            1、寄存器
            2、本地方法区
            3、方法区
            4、栈内存
                存储的都是局部变量（定义在方法或局部代码块中的变量）。
                而且变量所属的作用域一旦结束，该变量就自动释放
            5、堆内存
                存储的是数组和对象（其实数组就是对象）凡是new建立的都在堆中
                特点：
                    *   每一个实体都有首地址值。
                    **  堆内存的每一个变量都有默认初始化值，根据类型的不同而不同。
                        默认初始化值为0（int）、null（引用）、0.0（float）、false（Boolean）、char '\u0000'
                    *** 垃圾回收机制
     */
    public static void main(String[] args) {
        /*
        数组定义格式：
           元素类型[] 数组名= new 元素类型[元素个数或数组长度]
           元素类型[] 数组名= new 元素类型[]{元素，元素，...}
           元素类型[] 数组名= {元素，元素，...}
           */
        {//局部代码块，限定局部代码变量的生命周期
            int age=3;
            System.out.println(age);
        }
        int[] array=new int[3];
        int[] array2=new int[3];
        array[1]=89;
        array2=array;//array2也指向了array数组对象
        System.out.println(array[0]);
        System.out.println(array);//[I@1b6d3586打印数组地址的哈希值，[表示数组，I表示int类型。@表示分界符
        //System.out.println(array2[3]);//数组越界：ArrayIndexOutOfBoundsException
        array2=null;
        //System.out.println(array2[2]);//空指针异常：NullPointerException
    }
}
