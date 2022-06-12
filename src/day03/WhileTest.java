package day03;

public class WhileTest {
    public static void main(String[] args){
        /*
        练习：
        获取1到10,10个数字的和

        思路：
        1、每次参与加法的数值不确定
        2、每次出现的和数据也不确定
        3、发现参与加法运算的数值有递增规律
        4、每一次都是加法运算在重复，并且都是和再加上下一个数值。

        步骤：
        1、定义一个变量，记录参与加法运算的数据
        2、定义一个变量，记录每一次出现的和
        3、对于记录参与加法运算的数据进行自增
        4、因为加法运算需要重复，就要用到循环结构
         */

        //累加算法
        int x=1;//记录参与加法的数据
        int sum=0;//记录每一次的和
        while(x<=10){
            sum=sum+x;
            x++;
        }
        System.out.println("sum="+sum);
    }
}
