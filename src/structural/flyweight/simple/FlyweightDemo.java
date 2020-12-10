package structural.flyweight.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象享元类
 */
abstract class Flyweight {
    public abstract void print(UnsharedConcreteFlyweight extrinsic);
}

/**
 * 具体享元类, 负责为内蕴状态提供存储空间, 享元对象内蕴状态不可修改, 以确保可以复用
 */
class ConcreteFlyweight extends Flyweight {
    private final String state;                 // 不可再内部进行修改, 如果有内部状态更改的需求, 使用外蕴状态来处理.

    public ConcreteFlyweight(String state) {
        this.state = state;
    }

    @Override
    public void print(UnsharedConcreteFlyweight extrinsic) {
        System.out.printf("内蕴状态: %s, 外蕴状态: %s%n", state, extrinsic.getState());
    }
}

/**
 * 外蕴状态, 配置享元对象会发生变化的参数, 在必要时使用, 非必需
 */
class UnsharedConcreteFlyweight {
    private final String state;

    public UnsharedConcreteFlyweight(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

/**
 * 复合享元, 维持一个享元对象集合, 仅在需要组合时使用, 非必需
 */
class CompositeConcreteFlyweight extends Flyweight {
    private final Map<String, Flyweight> map = new HashMap<>();

    public void add(String key, Flyweight flyweight) {
        map.put(key, flyweight);
    }

    @Override
    public void print(UnsharedConcreteFlyweight extrinsic) {
        map.forEach((key, flyweight) -> flyweight.print(extrinsic));
    }
}

/**
 * 享元工厂
 */
class FlyweightFactory {
    // 内蕴状态, 享元池
    private static final Map<String, Flyweight> pool = new ConcurrentHashMap<>();

    // 单纯享元模式创建
    public static Flyweight open(String state) {
        if (pool.containsKey(state)) {
            System.out.println("get(" + state + ')');
            return pool.get(state);
        } else {
            System.out.println("new(" + state + ')');
            Flyweight flyweight = new ConcreteFlyweight(state);
            pool.put(state, flyweight);
            return flyweight;
        }
    }

    // 复合享元模式创建, 复合享元对象不会维护, 但会维护它包含的单纯享元对象.
    public static CompositeConcreteFlyweight open(String... states) {
        CompositeConcreteFlyweight ticket = new CompositeConcreteFlyweight();
        for (String state : states) {
            ticket.add(state, open(state));
        }
        return ticket;
    }
}

/**
 * @author yuzhian
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        System.out.println("------ 单纯享元模式 ------");
        Flyweight flyweight1 = FlyweightFactory.open("a");
        flyweight1.print(new UnsharedConcreteFlyweight("hello world"));
        Flyweight flyweight2 = FlyweightFactory.open("a");
        flyweight2.print(new UnsharedConcreteFlyweight("hello china"));
        System.out.println(flyweight1 == flyweight2);
        System.out.println("------ 复合享元模式 ------");
        Flyweight flyweight3 = FlyweightFactory.open("a", "b", "c");
        flyweight3.print(new UnsharedConcreteFlyweight("hello oracle"));
    }
}
