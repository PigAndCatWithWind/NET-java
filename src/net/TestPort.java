package net;

import java.net.InetSocketAddress;

public class TestPort {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("233.6.6.6", 80);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress2.getAddress());
    }
}
