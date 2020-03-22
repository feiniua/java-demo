package jvm.GC.Reference;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huu
 * @date: 2020/3/13 14:36
 * @description:
 *      -XX:+PrintGCDetails -verbose:gc 打印垃圾回收的详细信息
 */
public class SoftReferenceTest {

    private static int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
//        强引用导致堆内存溢出
//        List<byte[]> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new byte[_4MB]);
//        }
//
//        System.in.read();

//        软引用会自动清理
//        soft();

        ReferenceQueue<byte[]> queue =  new ReferenceQueue<>();

        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
//            关联了引用队列，当软引用关联的byte数组被回收时，软引用自己加入到队列中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

//        从list中删除引用队列中有的软引用
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("循环结束" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }

    public static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("循环结束" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
