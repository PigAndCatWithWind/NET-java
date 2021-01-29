package net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/29下午5:04
 * @描述
 * 熟悉流程
 * 创建客户端
 * 1. 建立链接  使用 Socket创建客户端 + 服务器的地址和端口
 * 2. 操作：输入输出流操作
 * 3. 释放资源
 */
public class Client {
    public static void main(String[] args) throws IOException {
//        1. 建立链接  使用 Socket创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
//        2. 操作：输入输出流操作
        OutputStream out = client.getOutputStream();
        DataOutputStream dataOutputStream  = new DataOutputStream(out);
        String string = "hello";
        dataOutputStream.writeUTF(string);
        dataOutputStream.flush();
//        3. 释放资源
        dataOutputStream.close();
        client.close();
    }
}
