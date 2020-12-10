package behavioral.chain.sample;

public class OddSupport extends Support {
    public OddSupport(String name) {                // 构造函数
        super(name);
    }

    protected boolean resolve(Trouble trouble) {    // 解决问题的方法
        return trouble.getNumber() % 2 == 1;
    }
}
