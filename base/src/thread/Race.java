package thread;

/**
 * @author: huu
 * @date: 2020/2/19 16:30
 * @description:
 */
public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {

            try {
                // 模拟乌龟速度
                if (Thread.currentThread().getName().equals("乌龟")) {
                    Thread.sleep(200);
                }

                // 模拟兔子速度
                if (Thread.currentThread().getName().equals("兔子")) {
                    Thread.sleep(100);
                }

                // 模拟兔子睡觉
                if (Thread.currentThread().getName().equals("兔子") && i == 8) {
                    Thread.sleep(2000);
                }

                boolean flag = gameOver(i);
                if (flag) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()
                        + "---->跑了" + i + "米");
            } catch (Exception ignored) {

            }

        }
    }

    private boolean gameOver(int step) {
        if (winner != null) {
            return true;
        }
        if (step == 10) {
            winner = Thread.currentThread().getName();
            System.out.println("winner--->" + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
