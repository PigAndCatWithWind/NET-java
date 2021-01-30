package chat.thread;

import java.io.Closeable;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/30上午11:31
 * @描述
 */
public class CloseUtil {
    public static void closeAll(Closeable... io){
        for (Closeable temp : io){
            try {
                if (null != temp) {
                    temp.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
