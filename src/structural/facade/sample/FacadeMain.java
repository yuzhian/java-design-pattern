package structural.facade.sample;

import structural.facade.sample.pagemaker.PageMaker;

public class FacadeMain {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
    }
}
