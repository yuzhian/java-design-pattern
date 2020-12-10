package behavioral.template_method.simple;

/**
 * 抽象类
 */
abstract class AbstractClass {
    protected final void initialize() { // 也可以将某些通用的步骤在抽象类中实现来简化子类, 但会降低子类的灵活性(子类无法选择如何初始化)
        System.out.println("准备");
    }

    protected boolean needInitialize() {
        return false;
    }

    protected abstract void action();

    protected abstract void finish();

    public final void execute() {   // 模板方法
        if (needInitialize())       // 钩子方法, 由子类覆写
            initialize();           // 具体方法, 由钩子方法控制是否执行
        action();                   // 抽象方法
        finish();                   // 抽象方法
    }
}

/**
 * 具体子类
 */
class ConcreteClass extends AbstractClass {
    @Override
    protected boolean needInitialize() {
        return true;
    }

    @Override
    public void action() {
        System.out.println("执行");
    }

    @Override
    protected void finish() {
        System.out.println("完成");
    }
}

/**
 * @author yuzhian
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        AbstractClass template = new ConcreteClass();
        template.execute(); // 调用父类模板方法
    }
}
