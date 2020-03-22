package decorator;

import decorator.service.Coffee;
import decorator.service.ProxyCoffee;
import decorator.service.SimpleCoffee;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Proxy;

/**
 * @author: huu
 * @date: 2020/3/20 10:57
 * @description:
 *      装饰器模式是在方法内部进行增强,装饰后还是本身当,要扩展一个类的功能时，用装饰
 *      代理模式是在方法外部修改被代理行为,对原有的方法进行改进。关闭数据库的close例子
 */
public class Test {
    public static void print(Coffee coffee) {
        System.out.println("Coffee=" + coffee.getCost()
                + " " + coffee.getIngredients());
    }

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        print(coffee);
        coffee = new WithMilk(coffee);
        print(coffee);


//        Coffee proxy = (Coffee) Proxy.newProxyInstance(coffee.getClass().getClassLoader()
//                , coffee.getClass().getInterfaces(), new ProxyCoffee(coffee));
//        System.out.println(proxy.getIngredients());
    }
}
