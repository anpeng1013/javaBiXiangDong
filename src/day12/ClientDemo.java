package day12;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //客户端发送数据到服务端。
        /**
         * TCP传输，客户端建立过程
         * 1、创建TCP客户端socket服务，使用的是Socket对象
         *      建议该对象一创建就明确目的地。
         * 2、如果连接建立成功，说明数据传输通道已建立。
         *      该通道就是socket流，是底层建立好的。既然是流，
         *      说明这里既有输入，也有输出。想要输入或者输出，
         *      可以使用Socket来获取，即可以通过getOutputStream()
         *      和getInputStream()来获取两个字节流。
         * 3、使用输出流，getOutputStream()。将数据写出
         * 4、关闭资源。
         */

        //创建客户端socket服务
        Socket socket = new Socket("192.168.56.1", 10001);//目的IP和端口

        //获取socket流中的输出流
        OutputStream outputStream = socket.getOutputStream();

        //使用输出将指定数据写出去
        outputStream.write("tcp演示：数据来了".getBytes());

        //读取服务器端返回的数据，使用socket读取流。
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        String text = new String(buffer, 0, length);
        System.out.println(text);

        //关闭资源
        socket.close();
    }
}
