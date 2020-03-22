package jvm.GC.Reference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: huu
 * @date: 2020/3/13 15:41
 * @description:
 *      -XX:+PrintGCDetails -verbose:gc 打印垃圾回收的详细信息
 */
public class WeakReferenceTest {

    private static int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.println(w.get() + " ");
            }
            System.out.println();
        }
        System.out.println("循环结束“”");
    }
}
