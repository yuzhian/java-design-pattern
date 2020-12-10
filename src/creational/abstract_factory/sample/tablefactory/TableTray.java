package creational.abstract_factory.sample.tablefactory;

import creational.abstract_factory.sample.factory.Item;
import creational.abstract_factory.sample.factory.Tray;

public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);                     // 使用super(...)表达式  
    }

    public String makeHTML() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("<td>");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");
        //noinspection SpellCheckingInspection
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"").append(tray.size()).append("\"><b>").append(caption).append("</b></td>");
        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        for (Object o : tray) {
            Item item = (Item) o;
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>");
        buffer.append("</td>");
        return buffer.toString();
    }
}
