package day04;

public class ArrayTest2 {
    public static void main(String[] args) {
        toHex(60);
        System.out.println(Integer.toHexString(60));
        toBinary(-60);
        System.out.println(Integer.toBinaryString(-60));
        toOctal(60);
        System.out.println(Integer.toOctalString(60));
    }

    //十进制-->十六进制
    public static void toHex(int num){
        trans(num,15,4);
    }
    //十进制-->八进制
    public static void toOctal(int num){
        trans(num,7,3);
    }
    //十进制-->二进制
    public static void toBinary(int num){
        trans(num,1,1);
    }

    public static void trans(int num,int base,int offset){
        if(num==0){
            System.out.println("0");
            return;
        }
        //定义一个表
        char[] ch={'0','1','2','3',
                '4','5','6','7',
                '8', '9','A','B',
                'C','D','E','F'};
        /*
        一会查表会查到比较多的数据。
        数据一多，就先存储起来，再进行操作，所以定义一个数组，
        临时容器。
         */
        char[] arr=new char[32];//int类型为32位
        int pos=arr.length;

        while (num!=0){//即使高位有1，中间有许多0，也可以。取其有效位。取多少个有效位就和多少个二进制的1相与。
            int temp =num & base;//若转换成16进制，从低位到高位，每次取4个二进制位，1111为15，所以和15相与。
            arr[--pos]=ch[temp];//直接存储在接收数组的末尾。pos先减一，再用作下标指示存储位置。
            num=num>>>offset;//每取一次有效位，操作数右移偏移量offset，如四个二进制位表示一个16进制数，所以，offset为4。
        }
        for (int i =pos; i <arr.length ; i++) {
            System.out.print(arr[i]);//pos指示了最高位置的有效位，从此开始输出相应的数制表示。
        }
        System.out.println();//换行。
    }
}
