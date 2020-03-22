package thread;

/**
 * @author: huu
 * @date: 2020/2/20 12:21
 * @description:
 *      线程停止不建议使用stop，destroy等
 */
public class TestThreadStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("thread + " + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestThreadStop threadStop = new TestThreadStop();
        new Thread(threadStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main + " + i);
            if(i == 900) {
                threadStop.stop();
                System.out.println("thread 停止");
            }
        }
    }
}
