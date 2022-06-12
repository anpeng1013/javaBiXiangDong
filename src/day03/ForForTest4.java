package day03;

public class ForForTest4 {
    public static void main(String[] args) {
        /*
        * * * * *
        -* * * *
        --* * *
        ---* *
        ----*
        由两个直角三角形组成
         */
        for (int i = 1; i <=5 ; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <= 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
