package behavioral.strategy.sample;

public class StrategyMain {
    public static void main(String[] args) {
        System.out.println("--- round one! ---");
        exec(Hand.HAND_VALUE_GUU, Hand.HAND_VALUE_GUU);
        System.out.println("--- round two! ---");
        exec(Hand.HAND_VALUE_CHO, Hand.HAND_VALUE_PAA);
    }

    private static void exec(int seed1, int seed2) {
        Player player1 = new Player("Taro", new WinningStrategy(seed1));
        Player player2 = new Player("Hana", new ProbStrategy(seed2));
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand1.isWeakerThan(nextHand2)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
