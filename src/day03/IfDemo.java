package day03;

public class IfDemo {
    public static void main(String[] args){

        {//局部代码块可以定义局部变量的生命周期，即作用域
            int m=5;
            System.out.println("m="+m);
        }
        //System.out.println("m="+m);m的作用域已经结束，访问不到m
        /*
       if语句的第一种格式：
       if（条件表达式）{//单分支结构
            执行语句；//条件表达式结果为真时，执行该语句，否则不执行。
       }
         */
        int x=3;
        if(x>1){//执行语句只有一条时，大括号可以不写。
            System.out.println("a");
        }
        System.out.println("b");

        /*
       if语句的第2种格式：
       if（条件表达式）{//两个分支，一次只能执行其中一个分支。
            执行语句；//条件表达式结果为真时，执行该语句。
       }
       else{
            执行语句；//条件表达式结果为假时，执行该语句。
       }
         */
        if(x>1){//其简写格式就是三元运算符，简写格式有局限性
            //简写格式在当if else运算后，有个具体结果时，可以简化成三元运算符
            System.out.println("aa");
        }
        else{
            System.out.println("bb");
        }
        System.out.println("cc");

        /*
        if语句第三种格式
        if（条件表达式）{//多个分支，一次只能执行其中一个分支。
            执行语句；//条件表达式结果为真时，执行该语句。
        }
        else if（条件表达式）{
            执行语句；//前面条件表达式为假，该条件表达式为真时
                        执行该语句。
       }
       else if（条件表达式）{
            执行语句；//前面条件表达式为假，该条件表达式为真时
                        执行该语句。
       }
       else{
            执行语句；//条件表达式结果为假时，执行该语句。
       }
         */
        if(x>1){
            System.out.println("aaa");
        }
        else if(x>2){
            System.out.println("bbb");
        }
        else if(x>3){
            System.out.println("ccc");
        }
        else
            System.out.println("ddd");

        //下面这段代码是三条if结构的语句。
        if(x>1){
            System.out.println("aaaa");
        }
        if(x>2){
            System.out.println("bbbb");
        }
        if(x>3){
            System.out.println("cccc");
        }
        else
            System.out.println("dddd");
    }
}
