package day03;

public class ForTest {
    public static void main(String[] args) {
        /*
        用for完成累加
        for和while的特点：
        1、for和while可以互换
        2、格式上的不同，在使用上有点小区别，
            如果需要通过变量来对循环进行控制，该变量只作为循环变量存在时，
            区别就体现出来了,即两个控制循环的变量作用域不同。
         */
        int sum = 0;
        for (int x = 1; x <= 10; x++) {
            sum = sum + x;
        }
        System.out.println("sum="+sum);

        int x=1;
        while(x<5){
            System.out.println("x="+x);
            x++;
        }
        System.out.println("可以继续打印x："+x);
        for(int y=1;y<5;y++){
            System.out.println("y="+y);
        }
        //不可以继续使用y。

        //无限循环的简单形式
        //while(true){}   for(; ;){}
    }
}
