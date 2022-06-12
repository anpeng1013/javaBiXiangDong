package day03;

public class DoWhilelDemo {
    /*
    do{
       执行语句；
    }while(条件表达式）
     */
    public static void main(String[] args){
        int x=1;
        do {
            System.out.println("x="+x);
            x++;
        }while (x<1);

        int y=1;
        while (y<1){
            System.out.println("y="+y);
            y++;
        }
    }
}
