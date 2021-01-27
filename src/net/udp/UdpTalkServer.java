package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/27下午9:17
 * @描述
 * 1 使用 DatagramSocket指定端口 创建接收端
 * 2 准备容器 封装 DatagramPacket包裹
 * 3 阻塞式接受包裹receive(DatagramPacket p)
 * 4 分析数据
 *      byte[] getData()
 *             getLength()
 * 5 释放资源
 */
public class UdpTalkServer {
    public static void main(String[] args) throws IOException {
        System.out.println("receive starting ......");
//                * 1 使用 DatagramSocket指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(3306);
//                * 2 准备容器 封装 DatagramPacket包裹
        byte[] bytes = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length );
//                * 3 阻塞式接受包裹receive(DatagramPacket p)
        while (true){
            server.receive(packet);
//                * 4 分析数据
//                *      byte[] getData()
//                *             getLength()
            byte[] data = packet.getData();
            int length = packet.getLength();
            System.out.println(new String(data,0,length));
        }

//                * 5 释放资源
//        server.close();

    }
}
