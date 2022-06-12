package day03;

public class ForForDemo {
    public static void main(String[] args) {
        //大圈套小圈思想
        /*for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("ok!");
            }
        }*/
        /*
        *****
        *****
        *****
        *****
         */
        for (int i = 0; i < 4; i++) {//外循环控制的是行数
            for (int j = 0; j < 5; j++) {//内循环控制的每一行的个数
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
