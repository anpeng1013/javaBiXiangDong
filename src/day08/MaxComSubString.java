package day08;

/*
获取两个字符串中最大相同的子串。
    "abdanpengdchf"
    "cdsanpenghgr"
    思路：
    1、既然取的是最大子串，先看短的那个字符串是否在长的那个字符串中。
        如果存在，短的那个字符串就是最大子串。
    2、如果不是，那么就将短的那个字符串长度递减的方式取子串，去长串中判断是否存在。
        如果存在就已找到，就不用再找了。
 */
public class MaxComSubString {
    public static void main(String[] args) {
        String s1 = "abdanpengdchf";
        String s2 = "cdsanpenghgr";
        String s = getMaxComSubString(s2, s1);
        System.out.println("s = " + s);
    }

    public static String getMaxComSubString(String s1, String s2) {
        String max=null,min=null;
        max=(s1.length()>s2.length())?s1:s2;
        min=max.equals(s1)?s2:s1;
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0, k = min.length() - i; k != min.length() + 1; j++, k++) {
                //这用到双指针法，k能取到length，是因为，substring(start，end)函数
                //取子串的时候只取到end位置的前一个,故当k等于length的时候，实际取到的
                // 末尾位置是length减一，故k不能大于length。
                String sub=min.substring(j,k);

                //System.out.println("sub = " + sub);//将每次取的子串打印出来。
                if(max.contains(sub))
                    return sub;
            }
        }
        return null;
    }
}
