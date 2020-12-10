package structural.adapter.sample_extends;

/**
 * 形式不合要求, 但能完成功能的实现类
 */
public class Banner {
    private final String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println('(' + string + ')');
    }

    public void showWithAster() {
        System.out.println('*' + string + '*');
    }
}
