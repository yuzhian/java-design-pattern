package structural.flyweight.sample;

import java.util.HashMap;

public class BigCharFactory {
    // Singleton模式
    private static final BigCharFactory singleton = new BigCharFactory();
    // 管理已经生成的BigChar的实例
    private final HashMap<String, BigChar> pool = new HashMap<>();

    // 构造函数
    private BigCharFactory() {
    }

    // 获取唯一的实例
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // 生成（共享）BigChar类的实例
    public synchronized BigChar getBigChar(char charName) {
        BigChar bc = pool.get("" + charName);
        if (bc == null) {
            bc = new BigChar(charName); // 生成BigChar的实例
            pool.put("" + charName, bc);
        }
        return bc;
    }
}
