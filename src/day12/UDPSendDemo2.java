package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo2 {
    public static void main(String[] args) throws IOException {
        /**
         * 创建UDP传输的发送端。
         * 思路：
         * 1、建立UDP的socket服务
         * 2、将要发送的数据封装到数据包中。
         * 3、通过UDP的socke服务将数据包发送出去。
         * 4、关闭socket服务。
         *
         */

        System.out.println("发送端启动...");
        //1、建立UDP的socket服务，使用DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        //2、将要发送的数据封装到数据包中
        // String string="UDP传输演示：数据包来了";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            byte[] buffer=line.getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(
                    buffer,buffer.length,InetAddress.getByName("192.168.56.1"),10000
            );
            //3、发送数据
            datagramSocket.send(datagramPacket);
            if("over".equals(line))
                break;
        }
        //4、关闭资源
        datagramSocket.close();
    }
}
