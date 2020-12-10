package structural.flyweight.sample;

public class BigString {
    // “大型字符”的数组
    private final BigChar[] bigChars;

    // 构造函数
    public BigString(String string) {
        bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // 显示
    public void print() {
        for (BigChar bigchar : bigChars) {
            bigchar.print();
        }
    }
}
