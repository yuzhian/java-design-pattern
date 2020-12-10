package behavioral.observer.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 观察目标
 */
abstract class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public abstract int getState();

    public abstract void changeState(int state);

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

/**
 * 具体观察目标
 */
class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void changeState(int state) {
        this.state = state;
        System.out.print("十进制: " + state + '\t');
        super.notifyAllObservers();
        System.out.println();
    }
}

/**
 * 抽象观察者
 */
abstract class Observer {
    public abstract void update(Subject subject);
}

/**
 * 具体观察者
 */
class ConcreteObserver8 extends Observer {
    @Override
    public void update(Subject subject) {
        System.out.print("八进制: " + Integer.toOctalString(subject.getState()) + '\t');
    }
}

class ConcreteObserver16 extends Observer {
    @Override
    public void update(Subject subject) {
        System.out.print("十六进制: " + Integer.toHexString(subject.getState()) + '\t');
    }
}

/**
 * @author yuzhian
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer8 = new ConcreteObserver8();
        Observer observer16 = new ConcreteObserver16();
        subject.addObserver(observer8);
        subject.addObserver(observer16);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            subject.changeState(random.nextInt(2 << 10));
        }
    }
}
