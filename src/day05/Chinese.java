package day05;

public class Chinese {

    private String name;//成员变量，也叫实例变量
    private int age;//成员变量，也叫实例变量。
    static String country="CN";//静态变量，也叫类变量
    // 而Chinese anpeng=new Chinese();中的anpeng是类类型变量。

    public Chinese(){
        return;
    }
    public Chinese(String name,int age){
        this.name=name;
        this.age=age;
    }
    static String getCountry(){
        //静态方法只能通过类名访问
        return Chinese.country;//类名访问静态变量
    }

    public void show(){//访问实例变量（非静态的特有数据
        System.out.println(Chinese.country+":my name is "+this.name+" and "+this.age+" years old.");
    }
    public String getName(){
        return this.name;//this对象引用访问实例变量
    }
//    public static String getName(){
//        return name;//静态方法只能访问静态成员（包括变量和方法）
//    }
}
