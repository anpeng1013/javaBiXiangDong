package day05;

/**
 * 建立一个用于操作数组的工具类，其中包括常见的对数组操作的函数如：最值，排序等。
 * @author anpeng
 * @version 1.0
 */
class ArrayTool{
    /*
    这种工具类中没有实例变量，类中的方法应该定义为static。
    工具类的方法直接可以通过类名.方法名进行调用，所以不需要创建对象。
    为了保证其他程序不要创建该类对象，可以将构造函数私有化。
     */
    private ArrayTool(){}//构造函数初始化。

    /**
     *
     * @param arr 接收一个元素为int类型的数组
     * @return 该数组的最大值
     */
    public static int getMax(int[] arr){//该方法没有访问非静态的特有数据，应该定义为静态方法。
        int maxIndex=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[maxIndex])
                maxIndex=i;
        }
        return arr[maxIndex];
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i <arr.length-1; i++) {//外循环确定比较轮数
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static int getIndex(int[] arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key)
                return i;
        }
        return -1;
    }
    public static int halfSearch(int[] arr,int key){
        int max,min,mid;
        min=0;
        max=arr.length-1;
        mid=(max+min)/2;
        while(min<=max){
            mid=(max+min)>>1;//右移一位，相当于除以2.
            if(key>arr[mid])
                min=mid+1;
            else if(key<arr[mid])
                max=mid-1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 将int数组转换成字符串，格式是：[e1,e2,...]
     * @param arr 接收一个int类型的数组
     * @return 返回该数组的字符串表现形式
     */
    public static String arrayToString(int[] arr){
        String str="[";
        for (int i = 0; i < arr.length; i++) {
            if(i!=arr.length-1)
                str=str+arr[i]+",";
            else
                str=str+arr[i]+"]";
        }
        return  str;
    }
}

public class ArrayToolDemo {
    public static void main(String[] args) {
        int[] arr={4,8,2,9,7,6};
//        ArrayTool arrayTool=new ArrayTool();//构造函数被私有化，不能创建实例

        int max=ArrayTool.getMax(arr);
        System.out.println("max="+max);

        int index=ArrayTool.getIndex(arr,10);
        System.out.println("index="+index);

        System.out.println(ArrayTool.arrayToString(arr));
        ArrayTool.selectSort(arr);
        System.out.println(ArrayTool.arrayToString(arr));
        System.out.println(ArrayTool.halfSearch(arr,8));
    }

}
