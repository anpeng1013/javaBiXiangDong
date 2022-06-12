package day05;

public class ThisDemo {
    /*
    this：代表当前对象，即调用该函数的对象，即this所在函数所属对象的引用。
          当局部变量和成员变量重名时，可以用this.成员变量名区分。
         注意：1、在调用成员函数或者构造函数时，方法栈中的当前执行函数维持一个
                this引用，用来指向堆中调用该函数的对象。
               2、this()语句只能写在构造函数第一行，因为初始化动作要先执行。
     */
    public static void main(String[] args) {
        Person xiechao=new Person("谢超",24);
        Person anpeng=new Person("安鹏",24);
        xiechao.speak();
        anpeng.speak();
        boolean peer=anpeng.compare(xiechao);
        System.out.println(peer);
    }
}
