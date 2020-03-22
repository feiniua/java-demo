package thread;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: huu
 * @date: 2020/2/20 15:17
 * @description:
 */
public class TestLock {
    public static void main(String[] args) {
        Buy buy = new Buy();
        new Thread(buy).start();
        new Thread(buy).start();
        new Thread(buy).start();
    }
}

class Buy implements Runnable {

    private int ticketNums = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticketNums > 0) {
                    System.out.println(ticketNums--);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
