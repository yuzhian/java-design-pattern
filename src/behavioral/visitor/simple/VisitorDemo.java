package behavioral.visitor.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 抽象元素
 */
abstract class Element {
    private final String name;

    public Element(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    abstract void accept(Visitor visitor);
}

/**
 * 具体元素
 */
class ConcreteElement extends Element {
    public ConcreteElement(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

/**
 * 对象结构, 此处装的是抽象元素, 与其他元素构成组合模式.
 */
class ObjectStructure extends Element {
    private final List<Element> elements = new ArrayList<>();

    public ObjectStructure(String name, Element... items) {
        super(name);
        Collections.addAll(elements, items);
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // 调用处理, 传入当前元素
    }
}

/**
 * 抽象访问者
 */
abstract class Visitor {
    abstract void visit(ConcreteElement element);

    abstract void visit(ObjectStructure wrapper);
}

/**
 * 具体访问者
 */
class ConcreteVisitor extends Visitor {
    private String path = "/";

    @Override
    public void visit(ConcreteElement element) {
        System.out.println(path + element.getName());
    }

    @Override
    public void visit(ObjectStructure wrapper) {
        String temp = path;
        System.out.println(path += wrapper.getName() + "/");
        wrapper.getElements().forEach(item -> item.accept(this)); // 访问元素, 传入当前访问者
        path = temp;
    }
}

/**
 * @author yuzhian
 */
public class VisitorDemo {
    public static void main(String[] args) {
        ObjectStructure root = new ObjectStructure("root", // 组合模式
                new ObjectStructure("11",
                        new ObjectStructure("21",
                                new ConcreteElement("e0")
                        ),
                        new ConcreteElement("e1")
                ),
                new ObjectStructure("12")
        );
        root.accept(new ConcreteVisitor());
    }
}
