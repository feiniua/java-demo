package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: huu
 * @date: 2020/2/20 14:23
 * @description:
 *      两个线程同时操作到了同一个位置
 */
public class TestUnsafeList {
    public static void main(String[] args) throws InterruptedException {
        // ArrayList 不安全
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                    list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());

        // JUC 并发编程安全list
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                    list1.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list1.size());
    }
}
