package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

/**
 * @author: huu
 * @date: 2020/2/2 22:17
 * @description:
 *      静态代理的两种方式
 *              继承：继承父类方法。如果有新的需求需要继续新加类，产生类爆炸
 *              聚合：目标对象和代理对象实现同一个接口。可复用，一样类爆炸
 *      动态代理的两种方式
 *              jdk动态代理：
 *              cglib动态代理：
 */
public class Test {
    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDaoImpl();

        // 静态代理
        UserDao userDaoStaticProxy = new UserDaoStaticProxy(new UserDaoImpl());
        userDaoStaticProxy.query("xiaoxiao");
        System.out.println("-----------------------");
//        UserDao userDaoMyDynamicProxy = (UserDao) ProxyUtil.newProxyInstance(userDao);
//        userDaoMyDynamicProxy.query("xiaoxiao");
//        System.out.println("-----------------------");
        // 动态代理
        UserDao userDaoJdkDynamicProxy = (UserDao) new MyJDKDynamicProxy(userDao).getProxy();
        userDaoJdkDynamicProxy.query("xiaoxiao");
        System.out.println("------------------------");

        // 未增强方法
        Method method = Class.forName("proxy.UserDao").getMethod("query", Class.forName("java.lang.String"));
        method.invoke(userDao,"123456");
        System.out.println("------------------------");

        // 获取代理时生成的class文件
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",UserDaoImpl.class.getInterfaces());
        String path = "E:\\IdeaProjects\\demo-jdkDebug\\design-patterns\\src\\proxy\\$Proxy0.class";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(classFile);
            fileOutputStream.flush();
            System.out.println("写入成功");
        } catch (Exception e) {
            System.out.println("写入失败");
        }

    }
}
