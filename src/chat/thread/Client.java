package chat.thread;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/30上午11:31
 * @描述
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);
        //控制台输入流
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        while(true){
            String info =console.readLine();
            //输出流
            dos.writeUTF(info);
            dos.flush();
            //输入流
            String msg =dis.readUTF();
            System.out.println(msg);
        }
    }
}
