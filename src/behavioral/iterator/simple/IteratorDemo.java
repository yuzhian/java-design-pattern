package behavioral.iterator.simple;

/**
 * 抽象迭代器
 * - 检查序列是否结束
 * - 访问下一个元素
 */
interface Iterator<E> {
    boolean hasNext();

    E next();
}

/**
 * 抽象聚合类
 * - 获得迭代器
 */
interface Aggregate<T> {
    Iterator<T> getIterator();
}

/**
 * 具体聚合类, 存储和管理元素
 *
 * @see java.util.ArrayList#grow() 扩容方法
 */
@SuppressWarnings("JavadocReference")
class ConcreteAggregate<T> implements Aggregate<T> {
    private final Object[] elements;    // 保存元素
    private int last = 0;               // 已存元素大小

    public ConcreteAggregate(int max) {
        this.elements = new Object[max];
    }

    public ConcreteAggregate<T> append(T t) {
        elements[last++] = t;           // 添加到当前位置, 并将指针指向下一个位置
        return this;
    }

    @Override
    public Iterator<T> getIterator() {
        return new ConcreteIterator();
    }

    /**
     * 具体迭代器, 内部类便于共享变量, 可以简化操作
     */
    private class ConcreteIterator implements Iterator<T> {
        private int cursor;             // 游标

        @Override
        public boolean hasNext() {
            return cursor < last;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {               // 如果有, 则返回当前元素, 并指向下一个元素
            return this.hasNext() ? (T) elements[cursor++] : null;
        }
    }
}

/**
 * @author yuzhian
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Aggregate<String> aggregate = new ConcreteAggregate<String>(5)
                .append("a")
                .append("b")
                .append("c")
                // .append("d")
                // .append("e")
                // .append("f")
                ;
        for (Iterator<String> iter = aggregate.getIterator(); iter.hasNext(); ) {
            System.out.println("string : " + iter.next());
        }
    }
}
