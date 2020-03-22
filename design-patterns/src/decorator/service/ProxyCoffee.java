package decorator.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: huu
 * @date: 2020/3/20 11:31
 * @description:
 */
public class ProxyCoffee implements InvocationHandler {
    private Object target;

    public ProxyCoffee(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKDynamicProxy-------before");
        Object result = method.invoke(target, args);
        System.out.println("JDKDynamicProxy-------after");
        return result;
    }
}
