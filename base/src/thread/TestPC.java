package thread;

import sun.security.krb5.internal.crypto.CksumType;

/**
 * @author: huu
 * @date: 2020/2/20 15:34
 * @description:
 *      测试生产者消费者模型 管程法
 */
public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Producer(container).start();
        new Consumer(container).start();
    }

}

// 生产者
class Producer extends Thread {
    SynContainer container;

    Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了第 " +  i + " 只鸡");
            container.push(new Chicken(i));
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer container;

    Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了--->" + container.pop().id + "只鸡");
        }
    }
}

// 产品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓存区
class SynContainer {
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        // 如果容器满了则等待消费者消费
        if (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满就加入产品
        chickens[count] = chicken;
        count++;

        // 一样可以通知消费者消费
        this.notifyAll();
    }

    // 消费者拿出产品
    public synchronized Chicken pop() {
        // 如果不能消费
        if (count == 0) {
            // 等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];

        // 吃了通知生产者生产
        this.notifyAll();

        return chicken;
    }
}
