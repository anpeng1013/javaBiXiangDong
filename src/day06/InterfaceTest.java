package day06;
/*
笔记本电脑使用。
    为了扩展笔记本的功能，但日后出现什么功能设备不知道定义一个规则，
只要日后出现的设备都符合这个规则就可以，规则在java中就是接口。
 */
interface USB{
    public void open();
    public void close();
}
class BookPC{
    public static void useUSB(USB usb){
        usb.open();
        usb.close();
    }
}
public class InterfaceTest {
    public static void main(String[] args) {
        BookPC bookPC=new BookPC();
        bookPC.useUSB(null);
    }
}
