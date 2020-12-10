package structural.adapter.sample_extends;

/**
 * 通过继承 {@link Banner}, 使用父类方法实现 {@link Print}.
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    public void printWeak() {
        showWithParen();
    }

    public void printStrong() {
        showWithAster();
    }
}
