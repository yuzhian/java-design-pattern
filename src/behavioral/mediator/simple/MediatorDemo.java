package behavioral.mediator.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象仲裁者
 */
abstract class Mediator {
    protected final Map<String, Colleague> colleagues = new HashMap<>();

    public void register(String key, Colleague colleague) {
        if (null != colleagues.get(key)) return;    // 防止二次注册
        colleague.setMediator(this);                // 成员在中介者中注册时将当前中介者交给成员
        this.colleagues.put(key, colleague);
    }

    public abstract void relay(String key, String message);
}

/**
 * 具体仲裁者
 */
class ConcreteMediator extends Mediator {
    @Override
    public void relay(String key, String message) {
        this.colleagues.get(key).receive(message);
    }
}

/**
 * 抽象同事类
 */
abstract class Colleague {
    public abstract void setMediator(Mediator mediator);

    public abstract void send(String key, String message);

    public abstract void receive(String message);
}

/**
 * 具体同事类
 */
class ConcreteMediatorA extends Colleague {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(String key, String message) {
        this.mediator.relay(key, message);
    }

    @Override
    public void receive(String message) {
        System.out.printf("具体同事A接收到消息 [%s]%n", message);
    }
}

class ConcreteMediatorB extends Colleague {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(String key, String message) {
        this.mediator.relay(key, message);
    }

    @Override
    public void receive(String message) {
        System.out.printf("具体同事B接收到消息 [%s]%n", message);
    }
}

/**
 * @author yuzhian
 */
public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague a = new ConcreteMediatorA();
        Colleague b = new ConcreteMediatorB();
        mediator.register("a", a);
        mediator.register("b", b);
        a.send("b", "message from a");
        b.send("a", "message from b");
    }
}
