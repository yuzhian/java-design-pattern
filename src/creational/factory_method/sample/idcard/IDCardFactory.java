package creational.factory_method.sample.idcard;

import creational.factory_method.sample.framework.Factory;
import creational.factory_method.sample.framework.Product;

import java.util.List;

public class IDCardFactory extends Factory {
    private final List<String> owners = new java.util.ArrayList<>();

    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }
}
