package structural.decorator.sample;

public class DecoratorMain {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world.");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();

        new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("hello, world!")
                                        ),
                                        '*'
                                )
                        )
                ),
                '/'
        ).show();
    }
}
