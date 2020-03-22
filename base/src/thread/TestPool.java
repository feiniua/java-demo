package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: huu
 * @date: 2020/2/20 16:28
 * @description:
 */
public class TestPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

    }
}

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}
