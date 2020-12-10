package structural.adapter.simple_entrust;

/**
 * 适配者类, 已有的类, 需要它的功能, 但不完全合要求, 需要做修改
 */
class Adaptee {
    @SuppressWarnings("SameReturnValue")
    public String get() {
        return "val";
    }
}

/**
 * 目标抽象类, 需求的方法形式
 */
abstract class Target {
    abstract void print();
}

/**
 * 对象适配器, 通过调用持有类的方法实现目标角色
 */
class Adapter extends Target {
    private final Adaptee adaptee = new Adaptee();

    @Override
    public void print() {
        System.out.println(adaptee.get()); // 调用持有类(适配者)方法
    }
}

/**
 * 请求者
 */
class Client {
    static void execute() {
        Target target = new Adapter();
        target.print();
    }
}

/**
 * @author yuzhian
 */
public class SimpleEntrustDemo {
    public static void main(String[] args) {
        Client.execute();
    }
}
