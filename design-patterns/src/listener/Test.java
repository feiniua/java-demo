package listener;

/**
 * @author: huu
 * @date: 2020/3/20 16:30
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.registerListener(new PersonListener() {
            @Override
            public void doEat(Event e) {
                Person p = e.getSource();
                System.out.println(p + "在吃东西");
            }

            @Override
            public void doRun(Event e) {
                Person p = e.getSource();
                System.out.println(p + "在跑步");
            }
        });
        person.eat();
    }
}
