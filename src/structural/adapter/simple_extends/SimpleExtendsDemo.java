package structural.adapter.simple_extends;

/**
 * 目标接口, 需求的方法形式
 */
interface Target {
    void print();
}

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
 * 类适配器, 通过继承使用父类方法实现目标角色
 */
class Adapter extends Adaptee implements Target {
    @Override
    public void print() {
        System.out.println(get()); // 使用父类(适配者)方法
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
public class SimpleExtendsDemo {
    public static void main(String[] args) {
        Client.execute();
    }
}
