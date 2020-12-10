package creational.builder.simple;

/**
 * 产品
 */
class Product {
    private Double x;
    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Product{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

/**
 * 抽象建造者, 建造模板
 */
abstract class Builder {
    protected final Product product;

    Builder() {
        product = new Product();
    }

    abstract void buildX();

    abstract void buildY();

    Product getProduct() {
        return product;
    }
}

/**
 * 具体建造者, 一种建造方案
 */
class ConcreteBuilder extends Builder {
    @Override
    void buildX() {
        product.setX(116.46);
    }

    @Override
    void buildY() {
        product.setY(39.92);
    }
}

/**
 * 指挥者, 指挥具体建造者按次序构造复杂对象
 */
class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildX();
        builder.buildY();
        return builder.getProduct();
    }
}

/**
 * 使用者
 */
class Client {
    void buildAndPrintProductByConstructBuilder() {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}

/**
 * @author yuzhian
 */
public class BuilderDemo {
    public static void main(String[] args) {
        new Client().buildAndPrintProductByConstructBuilder();
    }
}
