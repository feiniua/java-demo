package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: huu
 * @date: 2020/2/3 11:49
 * @description:
 *      jdk动态代理
 */
public class MyJDKDynamicProxy implements InvocationHandler {

    private Object target;

    public MyJDKDynamicProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKDynamicProxy-------before");
        Object result = method.invoke(target, args);
        System.out.println("JDKDynamicProxy-------after");
        return result;
    }
}
