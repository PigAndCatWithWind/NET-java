package net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/29下午4:59
 * @描述
 * 1. 指定端口 使用 Serversocket创建服务器
 * 2. 阻塞式等待链接accept
 * 3. 操作：输入输出流操作
 * 4. 释放资源
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
//        1. 指定端口 使用 Serversocket创建服务器
        ServerSocket server = new ServerSocket(8888);
//        2. 阻塞式等待链接accept
        Socket socket  = server.accept();
        System.out.println("a client link this server");
//        3. 操作：输入输出流操作
        InputStream inputStream = new BufferedInputStream(socket.getInputStream());
        OutputStream outputStream  = new BufferedOutputStream(new FileOutputStream("ChengZixiang-cpoy-with-tcp.html"));
        byte[] bytes = new byte[1024];
        int length = -1;
        while ((length=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,length);
        }
        outputStream.flush();;
//        4. 释放资源
        inputStream.close();
        outputStream.close();
        server.close();
    }
}
