package structural.decorator.simple;

/**
 * 抽象构件
 */
abstract class Component {
    abstract void print();
}

/**
 * 具体构件
 */
class ConcreteComponent extends Component {
    @Override
    public void print() {
        System.out.println(getClass().getSimpleName());
    }
}

/**
 * 抽象装饰类, 作为抽象构件的子类具有被装饰者相同的API以便重复装饰. 内部保存了被装饰者构件, 在被装饰者执行前后添加其他操作.
 */
abstract class Decorator extends Component {
    protected final Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void print() {
        printDecorate(); // 装饰操作
        component.print();
        printDecorate();
    }

    protected abstract void printDecorate();
}

/**
 * 具体装饰类
 */
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    protected void printDecorate() {
        System.out.println("---" + getClass() + "---");
    }
}

class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    protected void printDecorate() {
        System.out.println("+++" + getClass() + "+++");
    }
}

/**
 * @author yuzhian
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Component component;
        Component decorator;
        Component decorator1;
        component = new ConcreteComponent();
        decorator = new ConcreteDecorator(component);
        decorator1 = new ConcreteDecorator1(decorator);
        decorator1.print();

        System.out.println("==========================");

        component = new ConcreteComponent();
        decorator1 = new ConcreteDecorator1(component);
        decorator = new ConcreteDecorator(decorator1);
        decorator.print();
    }
}
