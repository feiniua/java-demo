package serviceloader.service;

/**
 * @author: huu
 * @date: 2020/3/19 22:35
 * @description:
 */
public class MyService1 implements IService {
    @Override
    public void print() {
        System.out.println("MyService---------1");
    }
}
