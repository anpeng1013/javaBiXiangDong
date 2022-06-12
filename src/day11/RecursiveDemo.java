package day11;

public class RecursiveDemo {
    public static void main(String[] args) {
        /**
         * 递归：
         * 函数自身直接或间接的调用自身。
         *
         * 使用时机：
         * 一个功能在重复使用，并每次使用时，参与运算的结果和上一次
         * 调用有关，这时可以用递归来解决问题。
         *
         * 注意：
         * 1、递归一定要明确条件，否则会栈内存溢出。
         * 2、
         */
//        toBinDemo();
        getSumDemo();
    }

    private static void getSumDemo() {
        int num=getSum(10);
        System.out.println("num = " + num);
    }

    private static int getSum(int num) {//计算的数字不能太大，
        //否则递归次数太多，会导致栈溢出。
        if(num==1)
            return 1;
        return num+getSum(num-1);
    }

    private static void toBinDemo() {
        toBin(15);//将一个十进制的数转换为二进制。
    }

    private static void toBin(int num) {
        if (num>0){
            toBin(num/2);
            System.out.print(num%2);
        }
    }
}
