package behavioral.visitor.sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private final String name;                    // 文件夹名字
    private final ArrayList<Entry> dir = new ArrayList<>();      // 目录条目集合

    public Directory(String name) {         // 构造函数
        this.name = name;
    }

    public String getName() {               // 获取名字
        return name;
    }

    public int getSize() {                  // 获取大小
        int size = 0;
        for (Object o : dir) {
            Entry entry = (Entry) o;
            size += entry.getSize();
        }
        return size;
    }

    public Entry add(Entry entry) {         // 增加目录条目
        dir.add(entry);
        return this;
    }

    public Iterator<Entry> iterator() {      // 生成Iterator
        return dir.iterator();
    }

    public void accept(Visitor v) {         // 接受访问者的访问
        v.visit(this);
    }
}
