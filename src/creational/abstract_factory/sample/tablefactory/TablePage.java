package creational.abstract_factory.sample.tablefactory;

import creational.abstract_factory.sample.factory.Item;
import creational.abstract_factory.sample.factory.Page;

public class TablePage extends Page {
    public TablePage(String title, String author) {
        super(title, author);
    }

    public String makeHTML() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("<html><head><title>").append(title).append("</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>").append(title).append("</h1>\n");
        buffer.append("<table width=\"80%\" border=\"3\">\n");
        for (Object o : content) {
            Item item = (Item) o;
            buffer.append("<tr>").append(item.makeHTML()).append("</tr>");
        }
        buffer.append("</table>\n");
        buffer.append("<hr><address>").append(author).append("</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
