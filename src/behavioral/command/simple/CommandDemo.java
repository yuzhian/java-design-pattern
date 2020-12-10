package behavioral.command.simple;

/**
 * 抽象命令类
 */
abstract class Command {
    abstract void execute();
}

/**
 * 具体命令类
 */
class ConcreteCommand1 extends Command {
    private final Receive receive;

    public ConcreteCommand1(Receive receive) {
        this.receive = receive;
    }

    @Override
    public void execute() {
        receive.execute1();
    }
}

class ConcreteCommand2 extends Command {
    private final Receive receive;

    public ConcreteCommand2(Receive receive) {
        this.receive = receive;
    }

    @Override
    public void execute() {
        receive.execute2();
    }
}

/**
 * 接收者
 */
class Receive {
    public void execute1() {
        System.out.println("execute1");
    }

    public void execute2() {
        System.out.println("execute2");
    }
}

/**
 * 调用者
 */
class Invoker {
    public void execute(Command command) {
        command.execute();
    }
}

/**
 * @author yuzhian
 */
public class CommandDemo {
    public static void main(String[] args) {
        Receive receive = new Receive();
        Invoker invoker = new Invoker();
        invoker.execute(new ConcreteCommand1(receive));
        invoker.execute(new ConcreteCommand2(receive));
    }
}
