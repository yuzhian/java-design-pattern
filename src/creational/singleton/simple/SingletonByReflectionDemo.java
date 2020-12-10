package creational.singleton.simple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 成员变量阻止第二次创建
 */
class PreventReflectionSingleton {
    private static final PreventReflectionSingleton instance = new PreventReflectionSingleton();
    private static boolean flag = false;

    private PreventReflectionSingleton() {
        synchronized (PreventReflectionSingleton.class) {
            if (flag) {
                throw new RuntimeException("Modified By Reflection!");
            }
            flag = true;
        }
    }

    public static PreventReflectionSingleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("PreventReflectionSingleton");
    }
}

/**
 * 反射直接访问private修饰的构造方法, 只要是类的单例都可以通过反射直接创建对象, 因此类的单例模式可以被攻击.
 * 枚举编译后是抽象类, 即使反射得到构造函数仍然无法创建对象.
 *
 * @author yuzhian
 */
public class SingletonByReflectionDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 类
        Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance() == HungrySingleton.getInstance());
        System.out.println(constructor.newInstance() == constructor.newInstance());

        // 枚举, 抽象类无法构造对象. (无法使用初始化方法. NoSuchMethodException)
        Constructor<EnumSingleton> constructor1 = EnumSingleton.class.getDeclaredConstructor();
        constructor1.setAccessible(true);
        System.out.println(constructor1.newInstance() == EnumSingleton.INSTANCE);
        System.out.println(constructor1.newInstance() == constructor1.newInstance());

        // 创建第二个实例的时候抛出异常. (构造方法中的自定义 RuntimeException)
        Constructor<PreventReflectionSingleton> constructor2 = PreventReflectionSingleton.class.getDeclaredConstructor();
        constructor2.setAccessible(true);
        System.out.println(constructor2.newInstance() == PreventReflectionSingleton.getInstance());
        System.out.println(constructor2.newInstance() == constructor2.newInstance());
    }
}
