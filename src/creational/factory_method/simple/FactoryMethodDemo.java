package creational.factory_method.simple;

/**
 * 抽象产品, 规定一组具体产品对外提供的功能.
 */
abstract class Product {
    public abstract void use();
}

/**
 * 具体产品
 */
class ConcreteProductA extends Product {
    @Override
    public void use() {
        System.out.println("使用具体产品A");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void use() {
        System.out.println("使用具体产品B");
    }
}

/**
 * 创建者, 在创建产品时容易做一些前置和后置的操作.
 */
abstract class Creator {
    public abstract Product create();
}

/**
 * 具体创建者
 */
class ConcreteCreatorA extends Creator {
    @Override
    public Product create() {
        // before create
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product create() {
        // before create
        return new ConcreteProductB();
    }
}

/**
 * @author yuzhian
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Creator creator;

        creator = new ConcreteCreatorA();
        creator.create().use();

        creator = new ConcreteCreatorB();
        creator.create().use();
    }
}
