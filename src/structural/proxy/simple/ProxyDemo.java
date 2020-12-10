package structural.proxy.simple;

/**
 * 主体
 */
abstract class Subject {
    abstract void operate();
}

/**
 * 实际的主体
 */
class RealSubject extends Subject {
    @Override
    public void operate() {
        System.out.println("do");
    }
}

/**
 * 代理人
 */
class Proxy extends Subject {
    private final Subject subject = new RealSubject();

    @Override
    public void operate() {
        System.out.println("before");
        subject.operate();
        System.out.println("after");
    }
}

/**
 * @author yuzhian
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.operate();
    }
}
