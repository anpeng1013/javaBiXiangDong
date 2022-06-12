package day12;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //服务端接收客户端发送过来的数据，并打印在控制台。
        /**
         * 建立TCP服务的思路：
         * 1、创建服务器的socket service，通过ServerSocket对象。
         * 2、服务端必须对外提供一个端口，否则客户端无法连接。
         * 3、获取连接过来的客户端对象。
         * 4、通过客户端对象获取socket流，读取客户端发来的数据。
         * 5、关闭连接资源。客户端和服务端都要关闭。
         */

        //创建服务端对象
        ServerSocket serverSocket=new ServerSocket(10001);

        //获取连接过来的客户端对象
        Socket socket=serverSocket.accept();
        String ip=socket.getInetAddress().getHostAddress();

        //通过socket对象获取输入流，要读取客户端发来的数据。
        InputStream inputStream=socket.getInputStream();
        byte[] buffer=new byte[1024];
        int length=inputStream.read(buffer);
        String text=new String(buffer,0,length);
        System.out.println(ip+":"+text);

        //使用客户端socket对象的输出流给客户端返回数据。
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("服务端收到".getBytes());

        //关闭资源
        serverSocket.close();//关闭服务器端
        socket.close();//关闭客户端。
    }
}
