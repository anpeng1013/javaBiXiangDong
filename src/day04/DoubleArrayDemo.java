package day04;

public class DoubleArrayDemo {
    /*
    二维数组的定义
        1、int[][] 数组名=new int[row][col];
        2、int[][] 数组名=new int[row][];
            注意：二维数组中的每一个小数组不一定是等长的，可以
            分别对其进行初始化。
        3、int[][] 数组名={{1,2},{3,4,5},{6,7,8,9}}
     */

    public static void main(String[] args) {
        int[][] arr=new int[3][2];//创建二维数组。
        //该数组中有3个一维数组，每个一维数组中有2个元素。

        System.out.println(arr);
        //直接打印二维数组地址的哈希值
        // [[I@1b6d3586 @左边是实体的类型 @右边是实体地址的哈希值

        System.out.println(arr[0]);
        //直接打印二维数组中第一个小数组地址的哈希值。
        // [I@4554617c @左边是实体的类型 @右边是实体地址的哈希值

        arr[0][0]=11;
        System.out.println("arr[0][0]="+arr[0][0]);//直接打印二维数组中第一个小数组的下标为0的元素。

        int[][] arr2=new int[3][];
        System.out.println("arr2[0]未分配内存时："+arr2[0]);//未分配前，地址值为null
        //System.out.println("arr2[0]未分配内存时："+arr2[0][0]);//未分配前，arr2[0]地址值为null,NullPointerException异常。
        arr2[0]=new int[1];
        arr2[1]=new int[2];
        arr2[2]=new int[3];//每个小数组的大小可以不一样
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }

        int[][] arr3={{1,2},{3,4,5},{6,7,8,9}};
        for (int i = 0; i < arr3.length; i++) {
            /*for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j]+",");
            }*/
            ArrayOperation.printArray(arr3[i]);//调用自己定义的打印数组函数
        }
    }

    /*
    二维数组的应用场景：
        数据的分类存储时。比如甲乙丙丁，四人一年中四个季度的绩效。
        甲：11,12,13,14
        乙：21,22,23,24
        丙：31,32,33,34
        丁：41,42,43,44
        int[][] scores=new[4][4];
     */
}


