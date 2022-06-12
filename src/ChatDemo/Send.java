package ChatDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable{
    private DatagramSocket datagramSocket;
    public Send(DatagramSocket datagramSocket){
        this.datagramSocket=datagramSocket;
    }
    @Override
    public void run() {
        try{
            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(System.in));
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                byte[] buffer=line.getBytes();
                DatagramPacket datagramPacket=
                        new DatagramPacket(buffer,buffer.length,
                                InetAddress.getByName("192.168.56.1"),10000);
                datagramSocket.send(datagramPacket);
                if("over".equals(line))
                    break;
            }
            datagramSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
