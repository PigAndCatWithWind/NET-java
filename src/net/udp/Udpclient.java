package net.udp;

import java.io.IOException;
import java.net.*;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/27下午9:16
 * @描述
    1 使用 DatagramSocket指定端口 创建接收端
    2 准备数据一定转化为字节数组
    3 封装 DatagramPacket包裹，需要指定目的地址
    4 发送包裹send(DatagramPacket p)
    5 释放资源
 */
public class Udpclient {

    public static void main(String[] args) throws IOException {
        System.out.println("send starting ......");
//        1 使用 DatagramSocket指定端口 创建接收端
        DatagramSocket client = new DatagramSocket(9999);
//        2 准备数据一定转化为字节数组
        String string = "use udp send data";
        byte[] bytes = string.getBytes();
//        3 封装 DatagramPacket包裹，需要指定目的地址
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                new InetSocketAddress("127.0.0.1",3306));
//        4 发送包裹send(DatagramPacket p)
        client.send(packet);
//        5 释放资源
        client.close();
    }
}
