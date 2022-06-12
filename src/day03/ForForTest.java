package day03;

public class ForForTest {
    public static void main(String[] args) {
        /*
        打印如下图案：
        *****
        ****
        ***
        **
        * 
         */
        int k=5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("*");
            }
            System.out.println();
            k--;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = k; j < 5; j++) {
                System.out.print("$");
            }
            System.out.println();
            k++;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
