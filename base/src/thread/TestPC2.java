package thread;

/**
 * @author: huu
 * @date: 2020/2/20 16:06
 * @description:
 */
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Wathcer(tv).start();
    }
}

// 生产者->演员
class Player extends Thread {
    TV tv;
    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("节目放送中----");
            } else {
                this.tv.play("广告时间马上回来");
            }
        }
    }
}

// 消费者->观众
class Wathcer extends Thread {
    TV tv;
    public Wathcer(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

// 产品->节目
class TV {
    String voice;
    boolean flag = true;

    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员表演了：" + voice);
        // 通知观众观看
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观看了：" + voice);
        // 通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}
