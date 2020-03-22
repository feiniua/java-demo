package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: huu
 * @date: 2020/2/19 14:05
 * @description:
 *      sleep模拟计时器
 */
public class Test {
    public static void main(String[] args) {
        Date curDate = new  Date();

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curDate));
                curDate = new Date();
            } catch (Exception e) {
            }
        }
    }
}
