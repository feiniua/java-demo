package thread;

/**
 * @author: huu
 * @date: 2020/2/20 13:48
 * @description:
 *      测试守护线程
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        // 启动上帝线程
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);
        godThread.start();

        new Thread(you).start();
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝守护着你--");
        }
    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一直活着---");
        }
        System.out.println("---goodbye");
    }
}

