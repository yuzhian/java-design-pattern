package creational.abstract_factory.simple;

/**
 * 抽象产品类
 */
abstract class AbstractProductA {
    abstract void print();
}

abstract class AbstractProductB {
    abstract void print();
}

/**
 * 具体产品类
 */
class XConcreteProductA extends AbstractProductA {
    @Override
    public void print() {
        System.out.println("X族A类");
    }
}

class YConcreteProductA extends AbstractProductA {
    @Override
    public void print() {
        System.out.println("Y族A类");
    }
}

class XConcreteProductB extends AbstractProductB {
    @Override
    public void print() {
        System.out.println("X族B类");
    }
}

class YConcreteProductB extends AbstractProductB {
    @Override
    public void print() {
        System.out.println("Y族B类");
    }
}

/**
 * 抽象产品工厂
 */
abstract class AbstractFactory {
    public abstract AbstractProductA getProductA();

    public abstract AbstractProductB getProductB();
}

/**
 * 具体产品工厂
 */
class XConcreteFactory extends AbstractFactory {
    @Override
    public AbstractProductA getProductA() {
        return new XConcreteProductA();
    }

    @Override
    public AbstractProductB getProductB() {
        return new XConcreteProductB();
    }
}

class YConcreteFactory extends AbstractFactory {
    @Override
    public AbstractProductA getProductA() {
        return new YConcreteProductA();
    }

    @Override
    public AbstractProductB getProductB() {
        return new YConcreteProductB();
    }
}

/**
 * 委托者, 封装调用方式, 简化外部调用(老板, 我要超级全家桶)
 */
class Client {
    public void getAndPrint(String family) { // 指定具体工厂即可获得一族产品
        AbstractFactory factory = switch (family) {
            case "X" -> new XConcreteFactory();
            case "Y" -> new YConcreteFactory();
            default -> throw new IllegalStateException("Unexpected value: " + family);
        };
        factory.getProductA().print();
        factory.getProductB().print();
    }
}

/**
 * X/Y 两个产品族, 各自实现了A/B两种产品;
 * 通过工厂获取一族产品.
 *
 * @author yuzhian
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Client client = new Client();
        client.getAndPrint("X");
        client.getAndPrint("Y");
    }
}
