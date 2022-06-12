package ChatDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Chat {
    public static void main(String[] args) throws SocketException {
        DatagramSocket send=new DatagramSocket();
        DatagramSocket receive=new DatagramSocket(10000);

        new Thread(new Send(send)).start();
        new Thread(new Receive(receive)).start();
    }
}
