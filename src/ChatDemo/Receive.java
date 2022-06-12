package ChatDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive implements Runnable {
    private DatagramSocket datagramSocket;

    public Receive(DatagramSocket datagramSocket){
        this.datagramSocket=datagramSocket;
    }
    @Override
    public void run() {
        try{
            while (true){
                //2、创建数据包
                byte[] buffer = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                //3、使用接收方法将数据存储到数据包中。
                datagramSocket.receive(datagramPacket);//阻塞式接收。
                //4、通过数据包对象的方法，解析其中的数据，比如地址，端口，数据内容。
                String ip = datagramPacket.getAddress().getHostAddress();
                int port = datagramPacket.getPort();
                String text = new String(datagramPacket.getData(),
                        0, datagramPacket.getLength());
                System.out.println(ip+":"+port+":"+text);
                if(text.equals("over")){
                    System.out.println(ip+"...退出聊天室");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
