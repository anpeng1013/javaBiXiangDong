package day06;

/*
异常处理的捕捉形式：
    这是可以对异常进行针对性的处理方式。
    具体格式是：
    try{
        //需要被检测异常的代码
    }catch(异常类 变量){//该变量用于接收发生的异常对象
        //处理异常的代码
    }catch(异常类 变量){//该变量用于接收发生的异常对象
        //处理异常的代码
    }finally{
        //一定会被执行的代码。
    }

    注意：如果程序段中有多个catch，则程序会去找到被检测代码（下面是method方法）
    中声明或抛出的第一个异常类型。当catch（Exception e)时，由于其他其他异常类都继承于Exception
    ，所以catch（Exception e)只能放在最后。父类的catch放在后面，否则编译失败。

异常处理原则：
    1、函数内部如果抛出需要检测的异常。那么函数必须要声明异常。
        否则必须要在函数内用try catch 捕捉，否则编译失败。
    2、如果调用了声明异常的函数，要么try catch要么throws，否则编译失败。
    3、使用catch的时机和throws的时机。
       功能内容可以解决，用catch。
       解决不了，用throws告诉调用者，有调用者解决。
    4、一个功能抛出了多个异常，那么调用时，必须有对应多个catch
        进行针对性的护理。
        内部有几个需要检测的异常，就抛几个异常，抛出几个就catch几个。

finally ：一定可以被执行语句
    当catch中用return时，finally语句依旧可以被执行
    但是，若catch中使用System.exit(0),finally 语句不可被执行。

try catch finally代码块
    1、try catch finally
    2、try catch（多个）当没有必要资源需要释放时，可以不用电仪finally
    3、try finally 异常无法直接catch处理，但是资源需要关闭。
        此时没有catch就没处理，函数体上需要声明异常。
 */

class TYDemo{
    public int method(int[] arr,int index) throws FuShuIndexException{
        if(arr==null){
            throw new NullPointerException("没有任何数组实体");
        }
        if(index<0){
            throw new FuShuIndexException("角标变成负数啦！");
        }

        return arr[index];
    }
}

public class TryCatchDemo {
    public static void main(String[] args) {//主函数内使用了try catch，就不用throws了。
        int[] arr=new int[3];
        TYDemo tyDemo=new TYDemo();
        try{
            int num =tyDemo.method(arr,-1);
            System.out.println("num="+num);//没有异常才会运行。
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }
        catch (FuShuIndexException e){
            System.out.println("Message:"+e.getMessage());

            System.out.println("String:"+tyDemo);//一般对象直接打印，会默认调用toString方法，打印的是对象类型和哈希值。
            System.out.println("String:"+e);// 但异常对象重写toString方法，直接打印时，是异常消息。与调用getMessage方法效果相同。

            e.printStackTrace();//打印异常的详细位置信息，JVM默认的异常处理机制。打印完后不会换行。
            System.out.println();

            System.out.println("负数角标异常！！");

            //return;//return后finally语句依旧可以被执行。
            System.exit(0);//正常退出JVM，finally语句不执行。
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("Program over...");
    }
}
