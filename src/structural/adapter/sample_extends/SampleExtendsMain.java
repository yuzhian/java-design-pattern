package structural.adapter.sample_extends;

/**
 * 类适配器, 使用继承方式
 */
public class SampleExtendsMain {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
