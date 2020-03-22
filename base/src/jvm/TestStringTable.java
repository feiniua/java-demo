package jvm;

/**
 * @author: huu
 * @date: 2020/2/22 16:31
 * @description:
 */
public class TestStringTable {
    /**
     * 常量池中的信息，都会被加载到运行时常量池中，这时 a b ab 都是常量池中的符号，
     * 还没有变成java字符串
     * 当执行到ldc #2时 才会把 a 符号变成"a"字符串(准备一份空间，StringTable[],将a作为key进去找，如果没有则放入StringTable中)
     * StringTable 哈希表结构 不能扩容
     *
     * 除了是编译期间用相同常量赋值的字符串变量的引用相同外,其它的全部是新的引用.因此,
     * 与这种变量直接用==相比时将得到false,即使内容相同(== 比较的是在堆中的引用)
     * @param args
     */
    public static void main(String[] args) {
//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "ab";
//        // new StringBuilder().append("a").append("b").toString()->new String("ab")
//        // new 出来的对象在堆里面
//        String s4 = s1 + s2;
//
//        // javac 在编译期间的优化成 "ab"
//        String s5 = "a" + "b";
//
//        System.out.println(s3 == s4);
//
//        new StringBuilder().append("a").append("b").toString()->new String("ab")
//        new 出来的对象在堆里面
        String s = new String("a") + new String("b");
        s.intern();
    }
}
