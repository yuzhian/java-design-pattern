package structural.flyweight.sample;

public class FlyweightMain {
    public static void main(String[] args) {
        handle("-0123456789");
        System.out.println("++++++++++++++++");
        handle("9");
    }

    private static void handle(String arg) {
        BigString bs = new BigString(arg);
        bs.print();
    }
}
