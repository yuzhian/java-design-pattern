package behavioral.state.simple;

/**
 * 抽象状态
 */
abstract class State {
    public abstract void doAction();
}

/**
 * 具体状态
 */
class ConcreteState1 extends State {
    public void doAction() {
        System.out.println("在状态1时执行的方法");
    }
}

class ConcreteState2 extends State {
    public void doAction() {
        System.out.println("在状态2时执行的方法");
    }
}

/**
 * 上下文
 */
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void execute() {
        this.state.doAction();
    }
}

/**
 * @author yuzhian
 */
public class StateDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteState1());
        context.execute();

        context.setState(new ConcreteState2());
        context.execute();
    }
}
