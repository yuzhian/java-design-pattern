package behavioral.strategy.sample;

public interface Strategy {
    Hand nextHand();

    void study(boolean win);
}
