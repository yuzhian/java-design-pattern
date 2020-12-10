package structural.flyweight.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    // 大型字符对应的字符串(由'#' '.' '\n'组成)
    private String fontData;

    // 构造函数
    public BigChar(char charName) {
        // 字符名字
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resource/character/big" + charName + ".txt"));
            StringBuilder buf = new StringBuilder();
            for (String line; (line = reader.readLine()) != null; ) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontData = buf.toString();
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    // 显示大型字符
    public void print() {
        System.out.print(fontData);
    }
}
