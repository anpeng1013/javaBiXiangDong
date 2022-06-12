package day08;

public class StringConstructorDemo {
    public static void main(String[] args) {
        stringConstructorDemo();
    }

    private static void stringConstructorDemo() {
        String s=new String();//等效于 String s="";但是不等效于String s=null;
        System.out.println("s = " + s);

        byte[] arr={97,98,99,100,65,66,67,68};
        String s1=new String(arr);
        System.out.println("s1 = " + s1);

        char[] chars={'a','n','p','e','n','g'};
        String s2=new String(chars);
        String s3=new String(chars,0,3);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
    }
}
