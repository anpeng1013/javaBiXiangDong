package day08;

/*
统计一个子串在整串中出现的次数。
    "nba haha nba anpeng nba huli nba"
    思路：
    1、要找的子串是否存在，如果存在获取其出现的位置。这个可以
        用indexOf完成。
    2、如果找到了，那么记录子串出现的位置并在剩余的字符串中继续查找该子串，
        而剩余字符串的起始位置是上次出现位置+子串长度。
    3、以此类推，通过循环完成查找，如果找不到就是-1，并对每次找到用计数器记录。
 */
public class CountSubString {
    public static void main(String[] args) {
        String str = "nba haha nba anpeng nba huli nba";
        String key = "nba";
//        int count = getKeyString_1(str, key);//这种方式，常量池中会出现很多子串。
//        System.out.println("count = " + count);
        int count=getKeyString_2(str,key);//这种方式不会在常量池产生过多的字符串常量
        System.out.println("count = " + count);
    }

    public static int getKeyString_2(String str, String key) {
        //1、定义计数器
        int count = 0;

        //2、定义变量记录key出现的位置
        int index = 0;

        //循环查找。
        while ((index = str.indexOf(key,index)) != -1) {
            index=index+key.length();//这种方式不会在常量池产生过多的字符串常量
            count++;
        }
        return count;
    }

    public static int getKeyString_1(String str, String key) {
        //1、定义计数器
        int count = 0;

        //2、定义变量记录key出现的位置
        int index = 0;

        //循环查找。
        while ((index = str.indexOf(key)) != -1) {
            str=str.substring(index+key.length());
            //这种方式，常量池中会出现很多子串。
            count++;
        }
        return count;
    }
}