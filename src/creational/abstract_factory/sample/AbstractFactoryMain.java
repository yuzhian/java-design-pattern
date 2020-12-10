package creational.abstract_factory.sample;

import creational.abstract_factory.sample.factory.Factory;
import creational.abstract_factory.sample.factory.Link;
import creational.abstract_factory.sample.factory.Page;
import creational.abstract_factory.sample.factory.Tray;

public class AbstractFactoryMain {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        // String clz = "listfactory.ListFactory";
        String clz = "tablefactory.TableFactory";

        Factory factory = Factory.getFactory("creational.abstract_factory.sample." + clz);

        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray trayNews = factory.createTray("日报");
        trayNews.add(people);
        trayNews.add(gmw);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(jp_yahoo);

        Tray traySearch = factory.createTray("检索引擎");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage("LinkPage", "杨文轩");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
