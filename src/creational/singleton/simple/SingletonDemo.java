package creational.singleton.simple;

/**
 * 枚举单例模式, 不仅可以解决线程同步问题, 还可以防止反序列化(反编译是抽象类, 无法直接创建对象).
 */
enum EnumSingleton {
    INSTANCE {
        @Override
        protected void print() {
            System.out.println("EnumSingleton");
        }
    };

    protected abstract void print();
}

/**
 * 饿汉式(即时加载), Class加载到内存时即创建实例对象(静态变量), jvm来保证线程安全, 最简单, 最实用.
 */
class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    public void print() {
        System.out.println("HungrySingleton");
    }
}

/**
 * 懒汉式(延迟加载, 懒加载), 多线程访问时存在多次实例化的可能.
 */
class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    // 可以在方法加锁, 但多线程效率较低
    public static LazySingleton getInstance() {
        if (null == instance) { // cpu在此切换线程时, 其他线程进行了实例化后, 此线程再次获取时间片时则会重复创建.
            instance = new LazySingleton();
        }
        return instance;
    }

    public void print() {
        System.out.println("LazySingleton");
    }
}

/**
 * 双重检查锁模式(延迟加载)
 */
class DoubleCheckLockingSingleton {
    // 阻止指令重排, 获取实时状态.
    private volatile static DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton() {
    }

    public static DoubleCheckLockingSingleton getInstance() {
        if (null == instance) {         // 避免已存在实例时进入同步代码块, 提升效率.
            synchronized (DoubleCheckLockingSingleton.class) {
                if (null == instance) { // 在线程等待时间片时会阻止其他线程实例化.
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }

    public void print() {
        System.out.println("DoubleCheckLockingSingleton");
    }
}

/**
 * 静态内部类模式(延迟加载), 利用语言特性, 使用内部类实现懒加载, 由jvm保证线程安全和对象唯一.
 */
class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return Holder.instance;
    }

    public void print() {
        System.out.println("StaticInnerClassSingleton");
    }

    private static class Holder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }
}

/**
 * 五种常见的单例模式写法
 *
 * @author yuzhian
 */
public class SingletonDemo {
    public static void main(String[] args) {
        // 测试懒汉式在多线程下的安全问题
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(LazySingleton.getInstance().hashCode())).start();
        }

        HungrySingleton.getInstance().print();
        System.out.println(HungrySingleton.getInstance() == HungrySingleton.getInstance());

        LazySingleton.getInstance().print();
        System.out.println(LazySingleton.getInstance() == LazySingleton.getInstance());

        DoubleCheckLockingSingleton.getInstance().print();
        System.out.println(DoubleCheckLockingSingleton.getInstance() == DoubleCheckLockingSingleton.getInstance());

        StaticInnerClassSingleton.getInstance().print();
        System.out.println(StaticInnerClassSingleton.getInstance() == StaticInnerClassSingleton.getInstance());

        EnumSingleton.INSTANCE.print();
        //noinspection ConstantConditions
        System.out.println(EnumSingleton.INSTANCE == EnumSingleton.INSTANCE);
    }
}
