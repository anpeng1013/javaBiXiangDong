package day04;

public class FunctionOverload {
    /*
    重载的概念：
        在同一个类中允许一个以上的同名函数，只要它们的参数个数
    或者参数类型或参数顺序不同即可
        1、同一个类中
        2、同名
        3、参数个数不同或参数类型、参数顺序不同
        4、函数重载和返回值类型无关。
        5、java是强类型和严谨性语言，如果函数出现调用的不确定性，
            会编译失败。
    特点：与返回值类型无关，只看参数列表
    好处：方便阅读，优化程序设计
     */
    //加法运算，两个整数的和
    public static int add(int a,int b){
        return a+b;
    }

    //加法运算，两个小数的和
    public static double add(double a,double b){
        return a+b;
    }

    //加法运算，三个整数的和
    public static int add(int a,int b,int c){
        return a+b+c;
    }

    //打印乘法表
    public static void printCFB(int num){
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
    }
    public static void printCFB(){
        printCFB(9);
    }
    public static void main(String[] args) {
        int sum=add(3,4,5);//调用加法
        System.out.println("sum="+sum);
        printCFB(8);//调用打印指定乘法表函数
        printCFB();//调用打印标准乘法表
    }
}
