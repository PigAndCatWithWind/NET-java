package net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/29下午5:04
 * @描述
 * 1. 建立链接  使用 Socket创建客户端 + 服务器的地址和端口
 * 2. 操作：输入输出流操作
 * 3. 释放资源
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
//        1. 建立链接  使用 Socket创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
//        2. 操作：输入输出流操作
        InputStream inputStream = new BufferedInputStream(new FileInputStream("ChengZixiang.html"));
        OutputStream outputStream  = new BufferedOutputStream(client.getOutputStream());
        byte[] bytes = new byte[1024];
        int length = -1;
        while ((length=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,length);
        }
        outputStream.flush();;

//        3. 释放资源
        outputStream.close();
        inputStream.close();
        client.close();
    }
}
