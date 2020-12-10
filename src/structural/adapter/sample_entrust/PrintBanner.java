package structural.adapter.sample_entrust;

/**
 * 持有 {@link Banner}, 通过调用持有类的方法实现 {@link Print}.
 */
public class PrintBanner extends Print {
    private final Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    public void printWeak() {
        banner.showWithParen();
    }

    public void printStrong() {
        banner.showWithAster();
    }
}
