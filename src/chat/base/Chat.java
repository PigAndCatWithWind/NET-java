package chat.base;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/29下午6:10
 * @描述
 */
public class Chat {
    public static void main(String[] args)  {
        System.out.println("chat");
        ServerSocket serverSocket  = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket finalSocket = socket;
        new Thread(()->{
            try (
                    DataInputStream dataInputStream = new DataInputStream(finalSocket.getInputStream());
                    DataOutputStream dataOutputStream = new DataOutputStream(finalSocket.getOutputStream())){
                while (true){
                    String msg = dataInputStream.readUTF();
                    System.out.println(msg);
                    dataOutputStream.writeUTF(msg);
                    dataOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
