package jvm.GC.gc;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: huu
 * @date: 2020/3/13 16:55
 * @description:
 *  堆初始大小：-Xms
 *  堆最大大小：-Xmx 或 -XX:MaxHeapSize=size
 *  新生代大小：-Xmn
 *  幸存区比例(动态)：-XX:InitialSurvivorRatio=ratio 和 -XX:UseAdaptiveSizePolicy
 *  幸存区比例：-XX:SurvivorRatio=ratio
 *  晋升阈值：-XX:MaxTenuringThreshold=threshold
 *  晋升详情：-XX:+PrintTenuringDistribution
 *  GC详情：-XX:+PrintGCDetails -verbose:gc
 *  FullGC前MinorGC：-XX:+ScavengeBeforeFullGC
 */
public class GCTest {

    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _2MB = 2 * _1MB;
    private static final int _6MB = 6 * _1MB;
    private static final int _7MB = 7 * _1MB;
    private static final int _8MB = 8 * _1MB;

    // -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) throws IOException, InterruptedException {
//        新生代空间逐渐占满，然后晋升到老年代
//        ArrayList<byte[]> list = new ArrayList<>();
//        list.add(new byte[_7MB]);
//        list.add(new byte[_512KB]);
//        list.add(new byte[_512KB]);

//        放入大对象时，新生代肯定存不下，便直接晋升到老年代
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();
        System.out.println("sleep-----------");
        Thread.sleep(10000);
    }
}
