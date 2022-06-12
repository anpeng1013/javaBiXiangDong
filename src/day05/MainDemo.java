package day05;

public class MainDemo {
    /*
    主函数的特殊之处：
        1、格式是固定的 public static void main(String[] args){}
        2、被JVM所识别和调用
            public:因为权限必须是最大的
            static：不需要对象，直接用主函数所属类名调用即可。
            void：主函数没有具体的返回值。因为是JVM调用的
            main：函数名，不是关键字，只是一个JVM识别的固定名字
            String[] args：主函数的参数列表，是一个数组类型的参数
                            数组元素都是字符串类型。
            args:字符串数组形参数组名，唯一可以改变的

     */
    public static void main(String[] args) {//new String args[0]，执行java程序时可传入的参数值

        System.out.println(args);//[Ljava.lang.String;@1b6d3586 数组实体对象的引用
        System.out.println(args.length);//长度为0
        for (int i = 0; i < args.length; i++) {//此处若不传参数，length等于0，不会进入循环。
            System.out.println(args[i]);//下标0表示第一个元素，但是若不传参数，字符串数组长度为0，会越界
        }
    }


}
