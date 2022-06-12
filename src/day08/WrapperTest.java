package day08;

import java.util.Arrays;

/*
对一个字符串中数值进行从小到大的排序。
    思路：
    1、要进行排序，可以用之前的选择排序，和冒泡排序。但是针对的是int类型。
    2、如何获取到这个字符串中的这些需要排序的数值呢？
        发现这个字符串中其实都是空格对数值进行分隔的，所以就想到用字符
        对象的切割方法将大串变成许多小串。
    3、数值最终变成小字符串，怎么变成一个int数呢？
        字符串-->基本类型 可以使用包装类的静态方法parseInt。

 */
public class WrapperTest {
    private static final String SPACE_SEPARATOR=" ";

    public static void main(String[] args) {
        String numStr = "20 78 9 -7  88 36 29";
        System.out.println(numStr);
        numStr = sortStringNumber(numStr);
        System.out.println(numStr);
    }

    public static String sortStringNumber(String numStr) {
        //1、将字符串变成字符串数组
        String[] str_arr = stringToArray(numStr);
        //2、将字符串数组变成int数组
        int[] num_arr = toIntArray(str_arr);
        //3、对int数组排序
        mySortArray(num_arr);
        //4、将排序后的int数组变成字符串。
        String temp = arrayToString(num_arr);
        return temp;
    }

    public static String arrayToString(int[] num_arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num_arr.length; i++) {
            if (i !=num_arr.length-1)
                sb.append(num_arr[i]+SPACE_SEPARATOR);
            else
                sb.append(num_arr[i]);
        }
        return sb.toString();
    }

    public static void mySortArray(int[] num_arr) {
        Arrays.sort(num_arr);//用的是快排算法。
    }

    public static int[] toIntArray(String[] str_arr) {
        int[] arr = new int[str_arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str_arr[i]);
        }
        return arr;
    }

    public static String[] stringToArray(String numStr) {
        String[] str_arr = numStr.split(SPACE_SEPARATOR+"+");//  +：匹配一个或多个
        return str_arr;
    }
}
