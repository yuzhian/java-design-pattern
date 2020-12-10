package creational.singleton.sample;

public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("生成一个实例。");
    }

    public static Singleton getInstance() {
        return singleton;
    }

    @SuppressWarnings("EmptyMethod")
    public void doSomething() {
    }
}
