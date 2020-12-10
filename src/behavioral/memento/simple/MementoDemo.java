package behavioral.memento.simple;

import java.util.ArrayList;
import java.util.List;

// 原发器
class Originator {
    private String state;

    public void change(String state) {      // 更改原发器状态
        this.state = state;
    }

    public Memento open() {                 // 返回一个备忘录对象
        return new Memento(this.state);
    }

    public void restore(Memento Memento) {  // 恢复备忘录状态
        state = Memento.getState();
    }

    @Override
    public String toString() {
        return state;
    }
}

/**
 * 备忘录, 保存原发器所有要备份的属性
 */
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

/**
 * 负责人, 实际保存备忘录的容器
 */
class Caretaker {
    private final List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }
}

/**
 * @author yuzhian
 */
public class MementoDemo {
    private static final Caretaker careTaker = new Caretaker();
    private static final Originator originator = new Originator();
    private static int index = -1;

    public static void main(String[] args) {
        originator.change("#0");
        save();
        originator.change("#1");
        save();
        originator.change("#2");
        save();
        originator.change("#3");
        save();
        originator.change("#4");
        save();
        undo();
        undo();
        redo();
    }

    // 保存状态, 移动指针
    private static void save() {
        System.out.println("--- 保存 ---");
        careTaker.add(originator.open());
        index++;
        System.out.println(originator);
    }

    private static void undo() {
        System.out.println("--- 撤销 ---");
        originator.restore(careTaker.get(--index));
        System.out.println(originator);
    }

    private static void redo() {
        System.out.println("--- 重做 ---");
        originator.restore(careTaker.get(++index));
        System.out.println(originator);
    }
}
