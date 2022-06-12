package day12;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        //获取本地主机IP地址对象
        InetAddress ip=InetAddress.getLocalHost();
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

        //获取其他主机的IP地址对象
        ip=InetAddress.getByName("www.baidu.com");
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
    }
}
