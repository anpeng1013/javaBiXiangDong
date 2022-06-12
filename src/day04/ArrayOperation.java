package day04;

public class ArrayOperation {
    /*
    对数组的最基本的操作就是存和取。
        核心思想：对角标的操作：0至length-1
     */
    public static void main(String[] args) {
        int[] array={11,32,11,14,22,17,33,44};
        int[] array2={11,32,14,22,33,44};
        System.out.println("array's length:"+array.length);//打印数组长度
        traversal(array);//遍历数组中的元素

        int max=getMax(array);//获取最大值
        System.out.println("max="+max);//打印数组最大值
        int min=getMin(array);//获取最小值
        System.out.println("Min="+min);//打印数组最小值

        System.out.print("选择排序前：");
        printArray(array);
        selectSort(array);//选择排序
        System.out.print("选择排序后：");
        printArray(array);

        System.out.print("冒泡排序前：");
        printArray(array2);
        bubbleSort(array2);//冒泡排序
        System.out.print("冒泡排序后：");
        printArray(array2);

        int index=getIndex(array,11);//普通查找
        System.out.println("index="+index);

        //二分查找只能用于有序数组
        int index1=halfSearch(array2,14);//二分查找法
        System.out.println("index1="+index1);

    }
    /*
       遍历数组，根据数组角标逐个取出数组的元素并打印。
        */
    public static void traversal(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("array["+i+"]="+arr[i]+";");
        }
    }
    /*
    打印数组的字符串表现形式。
     */
    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i!=arr.length-1)
                System.out.print(arr[i]+", ");
            else
                System.out.println(arr[i]+"]");
        }
    }

    /*
        获取数组中的最大值
        思路：
        1、需要进行比较，定义一个变量记录每次比较后的较大值。
        2、对数组中的元素进行遍历取出，和变量中记录的元素进行比较。
            如果遍历到的元素大于变量中记录的较大值，就用变量记录此时较大的值。
            否则，接着遍历下一元素。
        3、遍历结束，该变量中记录的就是最大值。
        定义一个功能来实现。
        明确一：是否有结果？
                有，是数组中的元素，int。
        明确二：是否有未知内容？
                有，是数组。
         */
    public static int getMax(int[] arr){
        //定义变量,记录较大的值
        int max=arr[0];//不能初始化为0，因为数组中的元素可能全部为负数。
        //若初始化为0，则存储的是数组最大值元素的角标
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static int getMin(int[] arr){
        //定义变量记录较小的值
        int min=arr[0];//不能初始化为0，因为数组中的元素可能全部为正数。
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    /*
    选择排序
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i <arr.length-1; i++) {//外循环确定比较轮数
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    /*
    冒泡排序，内循环中：
        -1：为了避免下标越界。
        -i：为了让外循环增加一次，最大的元素交换到最后，
            内循环参与比较的元素个数递减。
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){//相邻两个元素比较后换位置
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    /*
    数组常见功能：查找
     */
    public static int getIndex(int[] arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key)
                return i;//如果有两个相同的元素，那么返回的是第一元素的下标
        }
        return -1;
    }
    /*
    二分查找
     */
    public static int halfSearch(int[] arr,int key){
        int max,min,mid;
        min=0;
        max=arr.length-1;
        mid=(max+min)/2;
        while(arr[mid]!=key){
            if(key>arr[mid])
                min=mid+1;
            else if(key<arr[mid])
                max=mid-1;
            if(max<min)
                return -1;
            mid=(max+min)/2;
        }
        return mid;
    }


    /*
   面试题：
       给定一个有序的数组，如果往该数组中存储一个元素，并保证这个数组还是有序的，
   那么这个元素的存储下标该如何获取。二分查找中，查找不到时，返回min.
     */
}
