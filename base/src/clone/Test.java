package clone;

/**
 * @author: huu
 * @date: 2020/3/4 20:15
 * @description:
 *                 1）右边的“new Demo”，是以Demo类为模板，在堆空间里创建一个Demo对象。
 *                 2）末尾的()意味着，在对象创建后，立即调用Demo类的构造函数，对刚生成的对象进行初始化。 
 *                 3）左边的“Demo demo”创建了一个Demo类引用变量，它存放在栈空间中。也就是用来指向Demo对象的对象引用。 
 *                 4）“=”操作符使对象引用指向刚创建的那个Demo对象。
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("小红");
        person1.setAge1(9);
        person1.setAge2(9);

        Person person2 = new Person();
        person2.setName(person1.getName());
        person2.setAge1(person1.getAge1());
        person2.setAge2(person1.getAge2());

        person1.setName("123");
        person1.setAge1(10);
        person1.setAge2(10);

        System.out.println(person2.getName());
        System.out.println(person2.getAge1());
        System.out.println(person2.getAge2());
    }
}

class Person {

    private String name;

    private Integer age1;

    private int age2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge1() {
        return age1;
    }

    public void setAge1(Integer age1) {
        this.age1 = age1;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }
}
