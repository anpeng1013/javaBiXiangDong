package day02;

public class OperateDemo1 {
    public static void main(String[] args) {
        //算术运算符 +（加，连接符）    -（减）   * （乘）  /（除）   %（取余）
        //++(自增） --（自减）
        int x = 65536;
        x = x / 1000 * 1000;
        //两个int型相除还是int，即65536除以1000等于65，再乘以1000等于65000
        System.out.println(x);

        //"+"的连接符作用。
        System.out.println(3 + "2");
        int a = 4;
        int b = 5;
        System.out.println("a=" + a + "," + "b=" + b);//a=4,b=5

        //自增和自减
        System.out.println("a=" + a++);//先用a再加1
        System.out.println("a=" + ++a);//先加1再用a
        System.out.println("b=" + b--);//先用b再减1
        System.out.println("b=" + --b);//先减1再用b
    }
}