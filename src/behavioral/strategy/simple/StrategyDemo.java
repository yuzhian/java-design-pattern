package behavioral.strategy.simple;

/**
 * 抽象策略
 */
abstract class Strategy {
    abstract void print();
}

/**
 * 具体策略
 */
class ConcreteStrategy1 extends Strategy {
    @Override
    public void print() {
        System.out.println("使用具体策略1来解决问题");
    }
}

class ConcreteStrategy2 extends Strategy {
    @Override
    public void print() {
        System.out.println("使用具体策略2来解决问题");
    }
}

/**
 * 上下文, 使用策略解决问题
 */
class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.print();
    }
}

/**
 * @author yuzhian
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Context context1 = new Context(new ConcreteStrategy1());
        context1.execute();

        Context context2 = new Context(new ConcreteStrategy2());
        context2.execute();
    }
}
