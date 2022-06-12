package day04;

public class ArrayTest1 {
    /*
    获取一个整数的16进制表现形式

     */
    public static void main(String[] args) {
        toHex(60);
        System.out.println();
        toHex_1(60);
        System.out.println();
        toHex_2(60);
    }

    public static void toHex(int num) {
        for (int i = 0; i < 8; i++) {//四字最多有八个十六进制字符
            int temp = num & 15;
            if (temp > 9)
                System.out.print((char)(temp - 10 + 'A'));
            else
                System.out.print(temp);
            num = num >>> 4;
        }
    }

    //0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F
    //0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
    /*
    什么时候使用数组？
        如果数据出现了对应关系，而且对应关系的一方是有序的数字编号，并作为下标使用，
      这个时候就必须要想到数组的使用。可以将这些数据存储到数组中，根据运算的结果作为下标直接去
      数组中的对应的元素即可。这种方式：查表法。
     */
    public static void toHex_1(int num){
        //定义一个表
        char[] ch={'0','1','2','3',
                    '4','5','6','7',
                    '8', '9','A','B',
                    'C','D','E','F'};
        for (int i = 0; i < 8; i++) {
            int temp=num & 15;
            System.out.print(ch[temp]);
            num=num>>>4;//逻辑移位
        }
    }

    public static void toHex_2(int num){
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
        char[] arr=new char[8];
        int pos=arr.length;
        while (num!=0){
            int temp =num & 15;
            arr[--pos]=ch[temp];//直接存储在接收数组的末尾。pos先减一，再用作下标指示存储位置。
            num=num>>>4;//一个16进制数用四位二进制表示
        }
        for (int i =pos; i <arr.length ; i++) {
            System.out.print(arr[i]);
        }
    }
}
