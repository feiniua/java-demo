package lombda;

/**
 * @author: huu
 * @date: 2020/2/19 17:42
 * @description:
 */
public class TestLombda {
    public static void main(String[] args) {
        Move move;
        // 简化1.去掉参数
        move = (a) -> {
            System.out.println(a + "---");
        };
        move.lamda(1);

        // 简化2.去掉括号(单个参数可以去掉)
        move = a -> {
            System.out.println(a + "---");
        };
        move.lamda(1);

        // 简化3.去掉花括号(一行可以去掉)
        move = a -> System.out.println(a + "---");
        move.lamda(1);
    }
}

interface Move {
    void lamda(int a);
}


