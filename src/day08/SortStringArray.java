package day08;

/*
给定一个字符串数组。按照字典顺序进行从小到大的排序。
    {"nba","abc","cba","zz","haha"}
    思路：
        1、对数组排序。可以用选择，冒泡都行。
        2、for嵌套，比较以及换位。
        3、问题：以前排的都是基本数据，比较用的是比较运算符，可是现在比较的是字符串对象。
            怎么解决？String提供了字符串对象比较的功能：compareTo()
 */
public class SortStringArray {
    public static void main(String[] args) {
        String[] arr = {"nba", "abc", "cba", "zz", "haha"};
        System.out.println("字符串数组排序：");
        System.out.print("排序前：");
        printArray(arr);
        sortString(arr);
        System.out.print("排序后：");
        printArray(arr);
    }

    public static void printArray(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(arr[i] + ",");
            else
                System.out.println(arr[i] + "]");
        }
    }

    public static void sortString(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j])>0)//字符串对象比较。用compareTo方法完成。
                    swap(arr,i,j);
            }
        }
    }

    public static void swap(String[] arr, int i, int j) {
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
