package behavioral.observer.sample;

import java.util.ArrayList;

public abstract class NumberGenerator {
    private final ArrayList<Observer> observers = new ArrayList<>();    // 保存Observer们

    public void addObserver(Observer observer) {    // 注册Observer
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) { // 删除Observer
        observers.remove(observer);
    }

    public void notifyObservers() {                 // 向Observer发送通知
        for (Object observer : observers) {
            Observer o = (Observer) observer;
            o.update(this);
        }
    }

    public abstract int getNumber();                // 获取数值

    public abstract void execute();                 // 生成数值
}
