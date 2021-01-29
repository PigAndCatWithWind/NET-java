package net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/29下午4:59
 * @描述
 * 熟悉流程
 * 创建服务器
 * 1. 指定端口 使用 Serversocket创建服务器
 * 2. 阻塞式等待链接accept
 * 3. 操作：输入输出流操作
 * 4. 释放资源
 */
public class Server {
    public static void main(String[] args) throws IOException {
//        1. 指定端口 使用 Serversocket创建服务器
        ServerSocket server = new ServerSocket(8888);
//        2. 阻塞式等待链接accept
        Socket socket  = server.accept();
        System.out.println("a client link this server");
//        3. 操作：输入输出流操作
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String data = dataInputStream.readUTF();
        System.out.println(data);
//        4. 释放资源
        dataInputStream.close();
        server.close();
    }
}
