package day04;

public class FunctionDemo {
    /*
    定义函数格式：
    修饰符 返回值类型 函数名（参数类型 形式参数1，参数类型 形式参数2，..)
    {
        执行语句；
        return 返回值；//return 不仅可以返回值，还可以结束函数，return后面的语句不会执行。
    }
    细节：
    1、参数和返回值：
        * 有参函数：给老师五块钱，让老师给学生做饭，做好后老师端一碗饭给学生。
        * 无参函数：不给老师钱，老师免费给学生做饭。
        * 无返回值：学生给（或不给）老师五块钱让老师做饭，并自己吃，不用给学生。void修饰，
                    此时函数中的return语句可以省略不写
     2、函数中只能调用函数，不能在函数中定义函数，主函数中也不能定义函数。
     3、函数的处理结果应该返回给调用者，由调用者进行处理。
     4、返回值类型和参数类型没有直接关系。
     */

    /*
    需求1：定义一个功能，完成两个整数的和的获取
    思路：既然定义功能，就可以函数来体现
          如何定义一个函数？
          通过两个明确来完成
          明确一：这个功能的结果是什么？是和，是功能的结果，所以函数的
                  返回值类型是void。
          明确二：这个功能实现过程中是否需要未知内容参与运算？
                  有。加数和被加数。这就是函数的参数列表（参数个数，参数类型）
                  注意：返回值类型和参数类型没有直接关系。
     */
    public static int add(int a,int b){
        return a+b;
    }

    /*
    需求2：定义一个功能，画一个矩形在控制台。
    思路：既然定义功能，就可以函数来体现
          如何定义一个函数？
          通过两个明确来完成
          明确一：这个功能的结果是什么？
                  没有结果。因为直接打印到控制台了，并未返回给调用者。用void表示
          明确二：这个功能实现过程中是否需要未知内容参与运算？
                  有。行和列的个数不确定。两个整数int。
     */
    public static void draw(int row,int col){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }//return可以省略不写。
    }
    /*
        需求3：定义一个功能，比较两个数是否相等。
        思路：既然定义功能，就可以函数来体现
              如何定义一个函数？
              通过两个明确来完成
              明确一：这个功能的结果是什么？
                      有，Boolean。
              明确二：这个功能实现过程中是否需要未知内容参与运算？
                      有。两个比较的整数。
         */
    public static boolean equals(int a,int b){
       /*
       if(a==b)//第一种方法
            return true;
        else
            return false;
        return (a==b)?true:false;//第二种方法
        */
        return a==b;//最优方法
    }
    /*
            需求4：定义一个功能，获取两个整数中的最大值。
            思路：既然定义功能，就可以函数来体现
                  如何定义一个函数？
                  通过两个明确来完成
                  明确一：这个功能的结果是什么？
                          有，最大值。
                  明确二：这个功能实现过程中是否需要未知内容参与运算？
                          有。两个比较的整数。
             */
    public static int getMax(int a ,int b){
        /*
        if(a>b)//第一种方法
            return a;
        else
            return b;
            */
        return a>b?a:b;//最优解
    }
    /*
    定义功能，打印99乘法表
     */
    public static void print99(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
    }
    /*
    根据考试成绩获取学生分数对应的等级
    90~100      A
    80~99       B
    70~89       C
    60~79       D
    60以下      E
    结果：等级，字符，char
    参数：分数，int
     */
    public  char getLevel(int num){
        char level;
        if (num >= 90 && num<=100) {
            level= 'A';
        }else if(num>=80){
            level='B';
        }else if(num>=70){
            level='C';
        }else if(num>=60){
            level='D';
        }else
            level='E';
        return level;
    }

    public static void main(String[] args) {//主函数是静态的，只能调用静态方法。
        int c=add(3,4);//加法
        System.out.println("c="+c);
        draw(4,6);//画矩形
        equals(4,5);//比较两个数是否相等
        int m=getMax(34,21);//获取最大值
        System.out.println("Max="+m);
        print99();//打印99乘法表
        char d=new FunctionDemo().getLevel(78);//获取分数等级,利用匿名对象解决静态主函数访问非静态函数的问题。
        System.out.println("成绩等级为："+d);
    }

}
