package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: huu
 * @date: 2020/2/20 14:57
 * @description:
 *      死锁
 */
public class TestDeadLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(0,"0");
        Makeup makeup1 = new Makeup(1,"1");

        makeup.start();
        makeup1.start();
        Lock lock = new ReentrantLock();
    }
}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {
    private static Lipstick lipstick = new Lipstick();
    private static Mirror mirror = new Mirror();

    int choice;
    String name;

    public Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.name + "获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) {
                System.out.println(this.name + "获得镜子的锁");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.name + "获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipstick) {
                System.out.println(this.name + "获得口红的锁");
            }
        }
    }

}