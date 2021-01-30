package chat.base;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/29下午6:09
 * @描述
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("client");
        try (Socket socket = new Socket("127.0.0.1",8888);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {
            while (true){
                String msg = bufferedReader.readLine().trim();
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
                msg = dataInputStream.readUTF();
                System.out.println(msg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
