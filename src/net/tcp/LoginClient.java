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
public class LoginClient {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("place input user name : ");
        String name = bufferedReader.readLine().trim();
        System.out.print("place input user password : ");
        String password = bufferedReader.readLine().trim();
//        1. 建立链接  使用 Socket创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
//        2. 操作：输入输出流操作
        OutputStream out = client.getOutputStream();
        DataOutputStream dataOutputStream  = new DataOutputStream(out);
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        dataOutputStream.writeUTF(name +"&" + password);
        dataOutputStream.flush();
        String result = dataInputStream.readUTF();
        System.out.println(result);
//        3. 释放资源
        dataOutputStream.close();
        client.close();
    }
}
