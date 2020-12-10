package creational.builder.sample;

public class BuilderMain {
    public static void main(String[] args) {
        buildHtml();
        buildText();
    }

    // 输出到 /out/Greeting.html
    public static void buildHtml() {
        HTMLBuilder htmlbuilder = new HTMLBuilder();
        Director director = new Director(htmlbuilder);
        director.construct();
        String filename = htmlbuilder.getResult();
        System.out.println(filename + "文件编写完成。");
    }

    // 控制台
    private static void buildText() {
        TextBuilder textbuilder = new TextBuilder();
        Director director = new Director(textbuilder);
        director.construct();
        String result = textbuilder.getResult();
        System.out.println(result);
    }
}
