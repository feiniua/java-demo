package jvm;

/**
 * @author: huu
 * @date: 2020/2/22 14:15
 * @description:
 *      演示栈帧
 */
public class TestStack {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        method2(1,2);
    }

    private static int method2(int a, int b) {
        int c = a + b;
        return c;
    }
}
