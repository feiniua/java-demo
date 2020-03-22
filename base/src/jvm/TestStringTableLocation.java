package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huu
 * @date: 2020/3/11 19:43
 * @description:
 *  -Xmx10m 堆内存大小设置
 *  -XX:+PrintStringTableStatistics 打印常量池中的信息
 *  -XX:+PrintGCDetails -verbose:gc 打印垃圾回收的详细信息
 */
public class TestStringTableLocation {

    public static void main(String[] args) {
        int i = 0;
        try {
            for (int j = 0; j < 10000; j++) {
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
