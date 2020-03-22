package thread;

/**
 * @author: huu
 * @date: 2020/2/19 15:51
 * @description:
 *      通过实现Runnable实现线程
 */
public class TestRunnable implements Runnable {

    private static int sum = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程--" + sum--);
            if (sum < 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        TestRunnable runnable = new TestRunnable();
        new Thread(runnable).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main--" + sum--);
            if (sum < 0) {
                break;
            }
        }
    }
}
