package behavioral.chain.simple;

import java.util.Random;

/**
 * 抽象处理者
 */
@SuppressWarnings("CommentedOutCode")
abstract class Handler {
    private Handler next; // 责任链中的下一个元素

    public Handler next(Handler next) {
        return this.next = next;
    }

    @SuppressWarnings("CommentedOutCode")
    public void handle(int factor) {                            // 此方法也可与处理方法合并
        if (next == null) return;

        if (!resolve(factor)) next.handle(factor);              // 当一个处理者成功处理请求后, 忽略其他处理者
        // System.out.println(this.getClass().getSimpleName());    // 全部处理者都进行处理
        // next.handle(factor);
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean done() {
        System.out.println(this.getClass().getSimpleName());
        return true;
    }

    abstract protected boolean resolve(int factor);
}

/**
 * 具体处理者
 */
class ConcreteHandler extends Handler {
    @Override
    protected boolean resolve(int factor) {
        return factor % 3 == 0 && done();
    }
}

class ConcreteHandler1 extends Handler {
    @Override
    protected boolean resolve(int factor) {
        return factor % 3 == 1 && done();
    }
}

class ConcreteHandler2 extends Handler {
    @Override
    protected boolean resolve(int factor) {
        return factor % 3 == 2 && done();
    }
}

/**
 * 请求者, 非必须
 */
class Client {
    public void handle(int factor) {
        Handler handler = new ConcreteHandler();
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler.next(handler1).next(handler2);
        handler.handle(factor);
    }
}

/**
 * @author yuzhian
 */
public class ChainDemo {
    public static void main(String[] args) {
        int factor = new Random().nextInt(100);
        System.out.print("随机数: " + factor + ", 处理者: ");
        new Client().handle(factor);
    }
}
