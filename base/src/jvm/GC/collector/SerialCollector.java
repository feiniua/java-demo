package jvm.GC.collector;

/**
 * @author: huu
 * @date: 2020/3/15 16:37
 * @description:
 *      -XX:UseSerialGC=Serial+SerialOld
 *          新生代 复制算法
 *          老年代 标记整理算法
 */
public class SerialCollector {

    public static void main(String[] args) {
        System.out.println("helo");
    }
}
