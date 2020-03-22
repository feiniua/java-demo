package thread;

/**
 * @author: huu
 * @date: 2020/2/19 15:21
 * @description:
 *      创建线程的第一种方法继承Thread类
 *      重写run方法
 *      没有同步 出现线程不安全
 */
public class TestThread extends Thread {

    private static int sum = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程--" + sum--);
            if (sum < 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        TestThread testThread = new TestThread();
        testThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main--" + sum--);
            if (sum < 0) {
                break;
            }
        }
    }
}
