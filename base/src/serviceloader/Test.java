package serviceloader;

import serviceloader.service.IService;

import java.util.ServiceLoader;

/**
 * @author: huu
 * @date: 2020/3/19 22:35
 * @description:
 *      ServiceLoader src目录下的META-INF
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<IService> serviceLoader = ServiceLoader.load(IService.class);
        for (IService service : serviceLoader) {
            service.print();
        }
    }
}
