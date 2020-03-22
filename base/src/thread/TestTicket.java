package thread;

/**
 * @author: huu
 * @date: 2020/2/19 16:12
 * @description:
 *      获取当前线程的名字 Thread.currentThread().getName()
 *      模拟网络延时，放大问题的发生性
 */
public class TestTicket implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            synchronized (this) {
                if (this.ticket>0) {
                    try{
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName()+"卖票--->"+(ticket--));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TestTicket ticketRunnable = new TestTicket();
        new Thread(ticketRunnable, "线程1").start();
        new Thread(ticketRunnable, "线程2").start();
        new Thread(ticketRunnable, "线程3").start();

    }
}
