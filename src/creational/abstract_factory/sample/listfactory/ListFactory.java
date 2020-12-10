package creational.abstract_factory.sample.listfactory;

import creational.abstract_factory.sample.factory.Factory;
import creational.abstract_factory.sample.factory.Link;
import creational.abstract_factory.sample.factory.Page;
import creational.abstract_factory.sample.factory.Tray;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
