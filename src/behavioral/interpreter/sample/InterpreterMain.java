package behavioral.interpreter.sample;

import java.io.BufferedReader;
import java.io.FileReader;

public class InterpreterMain {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resource/program.txt"));
            for (String text; (text = reader.readLine()) != null; ) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
