package chat.thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/30上午11:32
 * @描述
 */
public class Receive implements Runnable {
    //输入流
    private DataInputStream dis ;
    //线程标识
    private boolean isRunning = true;
    public Receive() {
    }
    public Receive(Socket client){
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            isRunning =false;
            CloseUtil.closeAll(dis);
        }
    }
    /**
     * 接收数据
     * @return
     */
    public String  receive(){
        String msg ="";
        try {
            msg=dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            isRunning =false;
            CloseUtil.closeAll(dis);
        }
        return msg;
    }
    @Override
    public void run() {
        //线程体
        while(isRunning){
            System.out.println(receive());
        }
    }
}

