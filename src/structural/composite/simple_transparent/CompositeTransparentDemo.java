package structural.composite.simple_transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象构件, 声明所有方法, 叶子构件和容器构件的并集.
 */
abstract class Component {
    Component add(Component component) {
        throw new UnsupportedOperationException("当前构件不支持添加子元素");
    }

    abstract String getName();

    abstract void print();
}

/**
 * 叶子构件, 不应该存在子构件, 因此对于子构件的管理使用父类的默认抛异常.
 */
class Leaf extends Component {
    private final String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}

/**
 * 容器构件, 重写子构件的管理方法.
 */
class Composite extends Component {
    private final String name;
    private final List<Component> components = new ArrayList<>();   // 下一层元素列表, 通过抽象构件来兼容叶子和容器两种类型
    public Integer level;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public Composite add(Component component) {
        this.components.add(component);
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    @SuppressWarnings("DuplicatedCode")
    public void print() {                                           // 输出当前节点, 并为直接子节点添加缩进
        System.out.println(this.getName());
        if (this.level == null) {
            this.level = 1;
        }
        String prefix = "\t- ".repeat(this.level);
        for (Component component : this.components) {
            if (component instanceof Composite) {
                ((Composite) component).level = this.level + 1;
            }
            System.out.print(prefix);
            component.print();
        }
        this.level = null;
    }
}

/**
 * @author yuzhian
 */
public class CompositeTransparentDemo {
    public static void main(String[] args) {
        new Composite("[ROOT]")
                .add(new Composite("[A]")
                        .add(new Composite("[AA]")
                                .add(new Leaf("(AAA)"))
                                .add(new Leaf("(AAB)"))
                        )
                        .add(new Leaf("(AB)"))
                )
                .add(new Composite("[B]"))
                .print();
    }
}
