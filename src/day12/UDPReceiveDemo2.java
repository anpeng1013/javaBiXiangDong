package day12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo2 {
    public static void main(String[] args) throws IOException {
        /**
         * 建立UDP接收端的思路
         * 1、建立UDP的socket服务
         * 2、创建数据包，用于存储接收到的数据，方便用数据包对象的方法解析这些数据
         * 3、使用socket服务的receive方法将接收的数据存储到数据包中
         * 4、通过数据包的方法解析数据包中的数据
         * 5、关闭资源。
         */

        System.out.println("接收端启动...");
        //1、建立UDP的socket服务
        //必须指定端口
        DatagramSocket datagramSocket = new DatagramSocket(10000);

        //2、创建数据包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        while (true){
            //3、使用接收方法将数据存储到数据包中。
            datagramSocket.receive(datagramPacket);//阻塞式接收。

            //4、通过数据包对象的方法，解析其中的数据，比如地址，端口，数据内容。
            String ip = datagramPacket.getAddress().getHostAddress();
            int port = datagramPacket.getPort();
            String text = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

            System.out.println(ip+":"+port+":"+text);

        }

    }
}
