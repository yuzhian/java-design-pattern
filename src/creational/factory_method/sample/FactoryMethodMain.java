package creational.factory_method.sample;

import creational.factory_method.sample.framework.Factory;
import creational.factory_method.sample.framework.Product;
import creational.factory_method.sample.idcard.IDCardFactory;

public class FactoryMethodMain {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();
    }
}
