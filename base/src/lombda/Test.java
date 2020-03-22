package lombda;

/**
 * @author: huu
 * @date: 2020/2/19 17:15
 * @description:
 *      定义一个函数式接口（只有一个抽象方法的接口）
 */
public class Test {

    // 3.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lamda(int a) {
            System.out.println("i like lomda2" + a);
        }
    }

    public static void main(String[] args) {
        // 4.局部内部类
        class Like3 implements ILike {
            @Override
            public void lamda(int a) {
                System.out.println("i like lomda3" + a);
            }
        }

        ILike like = new Like();
        like.lamda(1000);

        like = new Like2();
        like.lamda(1000);

        like = new Like3();
        like.lamda(1000);

        // 5.匿名内部类，没有类的名称，必须借助接口或父类
        like = new ILike() {
            @Override
            public void lamda(int a) {
                System.out.println("i like lomda4" + a);
            }
        };
        like.lamda(1000);

        // 6.lombda简化
        like = (int a) -> {
            System.out.println("i like lomda5" + a);
        };
        like.lamda(1000);

    }
}

// 1.定义一个函数式接口
interface ILike {
    void lamda(int a);
}

// 2.实现类
class Like implements ILike {
    @Override
    public void lamda(int a) {
        System.out.println("i like lomda1" + "a");
    }
}
