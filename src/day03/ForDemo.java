package day03;

public class ForDemo {
    /*
    for(初始化表达式;循环条件表达式;每循环一次后的操作表达式）
    {
        执行语句；（循环体）
    }
     */
    public static void main(String[] args){
        for(int x=1;x<3;x++){
            System.out.println("x="+x);
        }
        int x=1;
        for(System.out.println("a");x<3;System.out.println("c")){
            System.out.println("b");
            x++;
        }
    }
}
