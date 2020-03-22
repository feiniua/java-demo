package proxy;

/**
 * @author: huu
 * @date: 2020/2/2 22:40
 * @description:
 *      静态代理
 */
public class UserDaoStaticProxy implements UserDao {

    private UserDao userDao;

    public UserDaoStaticProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void query(String name) {
        System.out.println("static proxy--------");
        userDao.query(name);
    }
}
