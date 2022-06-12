package day03;

public class SwitchDemo {
    public static void main(String[] args){
        /*
        switch(表达式）{
            case 取值1：
                执行语句；
                break；
            case 取值2：
                执行语句2；
                break；
            ......
            default:
                执行语句；
                break；
        }
         */
        int x=5;
        switch (x+1){//byte,short,int,char
            default:
                System.out.println("不匹配！");//当不匹配时，执行default语句，
                //匹配时，直接执行能执行的语句，直到遇见break或者大括号。
                //break;
            case 1:
                System.out.println("a");
                break;
            case 2:
                System.out.println("b");
                break;
            case 6:
                System.out.println("c");
                break;
            case 4:
                System.out.println("d");
                break;
        }
        int a=4,b=2;
        char opr='-';
        switch (opr){
            case '+':
                System.out.println(a+b);
                break;
            case '-':
                System.out.println(a-b);
                break;
            case '*':
                System.out.println(a*b);
                break;
            case '/':
                System.out.println(a/b);
                break;
                default:
                    System.out.println("无法运算！符号不支持");
                    break;
        }
    }
}
