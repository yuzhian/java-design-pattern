package behavioral.command.sample.drawer;

import behavioral.command.sample.command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    // 颜色
    private final Color color = Color.red;
    // 命令的历史记录
    private final MacroCommand history;

    // 构造函数
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 重新全部绘制
    public void paint(Graphics g) {
        history.execute();
    }

    // 绘制
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        // 要绘制的圆点的半径
        int radius = 6;
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
