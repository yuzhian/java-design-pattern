package structural.proxy.sample;

public interface Printable {
    String getPrinterName();            // 获取名字

    void setPrinterName(String name);   // 设置名字

    void print(String string);          // 显示文字（打印输出）
}
