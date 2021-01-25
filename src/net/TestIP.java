package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIP {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP: "+inetAddress.getHostAddress()+" ---> computer name: "+inetAddress.getHostName());

        inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("IP: "+inetAddress.getHostAddress()+" ---> computer name: "+inetAddress.getHostName());

        inetAddress = InetAddress.getByName("8.8.8.8");
        System.out.println("IP: "+inetAddress.getHostAddress()+" ---> computer name: "+inetAddress.getHostName());
    }
}
