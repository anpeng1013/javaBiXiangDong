package day03;

public class ForForTest2 {

    public static void main(String[] args) {
        /*
         *
         **
         ***
         ****
         *****
         */
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("--------");

        /*
        54321
        5432
        543
        54
        5
         */
        for (int i = 1; i <= 5; i++) {
            for(int j=5;j>=i;j--){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("--------");
        /*
        1
        12
        123
        1234
        12345
         */
        for (int i = 1; i <=5; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
