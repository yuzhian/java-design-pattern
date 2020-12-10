package behavioral.memento.sample.game;

import java.util.ArrayList;

public class Memento {
    final int money;                        // 所持金钱
    final ArrayList<String> fruits;         // 当前获得的水果

    Memento(int money) {                    // 构造函数(wide interface)
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    public int getMoney() {                 // 获取当前所持金钱（narrow interface）
        return money;
    }

    void addFruit(String fruit) {           // 添加水果(wide interface)
        fruits.add(fruit);
    }

    @SuppressWarnings("unchecked")
    ArrayList<String> getFruits() {         // 获取当前所持所有水果（wide interface）
        return (ArrayList<String>) fruits.clone();
    }
}
