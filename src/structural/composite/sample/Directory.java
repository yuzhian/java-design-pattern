package structural.composite.sample;

import java.util.ArrayList;

public class Directory extends Entry {
    private final String name;                                      // 文件夹的名字
    private final ArrayList<Entry> directory = new ArrayList<>();   // 文件夹中目录条目的集合

    public Directory(String name) {                                 // 构造函数
        this.name = name;
    }

    public String getName() {                                       // 获取名字
        return name;
    }

    public int getSize() {                                          // 获取大小
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    public void add(Entry entry) {                                  // 增加目录条目
        directory.add(entry);
    }

    protected void printList(String prefix) {                       // 显示目录条目一览
        System.out.println(prefix + "/" + this);
        for (Object o : directory) {
            Entry entry = (Entry) o;
            entry.printList(prefix + "/" + name);
        }
    }
}
