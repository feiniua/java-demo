package jvm;

/**
 * @author: huu
 * @date: 2020/2/22 15:21
 * @description:
 *      测试堆内存
 */
public class TestHeap {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1..........");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10];
        System.out.println("2..........");
        Thread.sleep(30000);
        array = null;
        System.gc();
        System.out.println("3..........");
        Thread.sleep(100000L);
    }
}
