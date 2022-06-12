package day08;

/*
模拟一个trim功能相同的方法，去除字符串两端的空白。
    思路：又是双指针法。
    1、定义两个变量：一个从头开始判断字符串空格的角标，一个
        从尾部开始判断字符串空格的角标。
    2、判断到不是空格为止，取头尾之间的子串即可。

 */
public class myTrimDemo {
    public static void main(String[] args) {
        String s = "   ab c   ";
        System.out.println("-" + s + "-");

        s = myTrim(s);
        System.out.println("-" + s + "-");
    }

    public static String myTrim(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }
        while (start <= end && s.charAt(end) == ' ') {
            end--;
        }
        return s.substring(start, end + 1);//该方法包含头不包含尾
    }

}
