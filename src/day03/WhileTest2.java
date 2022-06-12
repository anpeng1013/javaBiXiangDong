package day03;

public class WhileTest2 {
    /*
    练习：
    1~100之间 6的倍数出现的次数
     */
    public static void main(String[] args){
        int x=1;
        int count=0;
        while(x<=100){
            if(x%6==0)
                count++;
            x++;
        }
        System.out.println("count="+count);
    }
}
