package behavioral.chain.sample;

public class LimitSupport extends Support {
    private final int limit;                        // 可以解决编号小于limit的问题

    public LimitSupport(String name, int limit) {   // 构造函数
        super(name);
        this.limit = limit;
    }

    protected boolean resolve(Trouble trouble) {    // 解决问题的方法
        return trouble.getNumber() < limit;
    }
}
