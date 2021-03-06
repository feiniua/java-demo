package listener;

/**
 * @author: huu
 * @date: 2020/3/20 16:30
 * @description:
 *      事件源 事件监听器 事件对象
 */
public class Person {
    /**
     * @Field: listener
     *          在Person类中定义一个PersonListener变量来记住传递进来的监听器
     */
    private PersonListener listener;

    /**
     * @Method: eat
     * @Description: 设计Person的行为：吃
     * @Anthor:孤傲苍狼
     *
     */
    public void eat() {
        if (listener != null) {
            /**
             * 调用监听器的doeat方法监听Person类对象eat(吃)这个动作，将事件对象Event传递给doeat方法，
             * 事件对象封装了事件源，new Event(this)中的this代表的就是事件源
             */
            listener.doEat(new Event(this));
        }
    }

    /**
     * @Method: run
     * @Description: 设计Person的行为：跑
     * @Anthor:孤傲苍狼
     *
     */
    public void run() {
        if (listener != null) {
            /**
             * 调用监听器的dorun方法监听Person类对象run(跑)这个动作，将事件对象Event传递给doeat方法，
             * 事件对象封装了事件源，new Event(this)中的this代表的就是事件源
             */
            listener.doRun(new Event(this));
        }
    }

    /**
     * @Method: registerListener
     * @Description: 这个方法是用来注册对Person类对象的行为进行监听的监听器
     * @Anthor:孤傲苍狼
     *
     * @param listener
     */
    public void registerListener(PersonListener listener) {
        this.listener = listener;
    }
}

/**
 * @ClassName: PersonListener(事件监听器)
 * @Description: 设计Person类(事件源)的监听器接口
 * @author: 孤傲苍狼
 * @date: 2014-9-9 下午9:28:06
 *
 */
interface PersonListener {

    /**
     * @Method: doeat
     * @Description: 这个方法是用来监听Person对象eat(吃)这个行为动作，
     *                 当实现类实现doeat方法时就可以监听到Person类对象eat(吃)这个动作
     * @Anthor:孤傲苍狼
     *
     * @param e
     */
    void doEat(Event e);

    /**
     * @Method: dorun
     * @Description: 这个方法是用来监听Person对象run(跑)这个行为动作，
     *                 当实现类实现dorun方法时就可以监听到Person类对象run(跑)这个动作
     * @Anthor:孤傲苍狼
     *
     * @param e
     */
    void doRun(Event e);

}

/**
 * @ClassName: Event(事件对象)
 * @Description:设计事件类，用来封装事件源
 * @author: 孤傲苍狼
 * @date: 2014-9-9 下午9:37:56
 *
 */
class Event {

    /**
     * @Field: source
     *          事件源(Person就是事件源)
     */
    private Person source;

    public Event() {

    }

    public Event(Person source) {
        this.source = source;
    }

    public Person getSource() {
        return source;
    }

    public void setSource(Person source) {
        this.source = source;
    }
}