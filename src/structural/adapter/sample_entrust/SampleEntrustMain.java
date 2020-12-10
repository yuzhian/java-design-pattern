package structural.adapter.sample_entrust;

/**
 * 对象适配器, 使用委托方式
 */
public class SampleEntrustMain {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
