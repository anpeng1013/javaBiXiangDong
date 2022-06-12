package day08;

/*
将一个int数组变成字符串
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arrayToString_1(arr));//String拼接形式，会产生较多的字符串对象在常量池中。
        System.out.println(arrayToString_2(arr));//不会产生新的字符串对象。

    }

    public static String arrayToString_2(int[] arr) {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i!=arr.length-1)
                sb.append(arr[i]+",");
            else
                sb.append(arr[i]+"]");
        }
        return sb.toString();
    }

    public static String arrayToString_1(int[] arr) {
        String string = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                string += arr[i] + ",";
            else
                string += arr[i] + "]";
        }
        return string;
    }

}
