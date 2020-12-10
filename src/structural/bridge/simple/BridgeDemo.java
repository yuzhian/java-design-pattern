package structural.bridge.simple;

/**
 * 实现者: 位于"类的实现层次结构"最上层, 定义了抽象化用到的基本功能
 */
interface Implementor {
    void print();
}

/**
 * 具体实现者: 基本功能的一个实现方案
 */
class ConcreteImplementor implements Implementor {
    public void print() {
        System.out.println("拥有基本功能");
    }
}

/**
 * 抽象化(桥): 位于"类的功能层次结构"最上层, 委托实现者完成基本功能.
 * 抽象化并不是说类是抽象类(抽象化和扩充都可以是普通类), 而是说他们针对抽象实现编程.
 */
class Abstraction {
    protected final Implementor implementor; // 使用委托方式弱化扩充抽象化角色和实现者之间的耦合.

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void print() {
        this.implementor.print(); // 通过实现实现者完成基本功能.
    }
}

/**
 * 扩充抽象化: 在抽象化的基础上增加了新的功能
 * 如果要在此扩充功能的基础上继续扩充的话, 继承此类并在调用方使用新扩展类来定义变量并实例化;
 * 如果要更改此扩充功能的实现方案的话, 继承此类并使用新扩展类实例化.
 */
class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor Implementor) {
        super(Implementor);
    }

    public void printElse() {
        System.out.println("拥有拓展功能");
    }
}

/**
 * @author yuzhian
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor();

        Abstraction abstraction = new Abstraction(implementor);
        abstraction.print();

        System.out.println("===");

        Abstraction abstraction2 = new RefinedAbstraction(implementor);
        abstraction2.print();

        System.out.println("===");

        RefinedAbstraction refinedAbstraction = new RefinedAbstraction(implementor);
        refinedAbstraction.print(); // 通过"桥"访问实现者中的基本功能.
        refinedAbstraction.printElse(); // 扩充功能.
    }
}
