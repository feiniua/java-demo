package proxy;

/**
 * @author: huu
 * @date: 2020/2/2 22:39
 * @description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void query(String name) {
        System.out.println("query --- " + name);
    }
}
