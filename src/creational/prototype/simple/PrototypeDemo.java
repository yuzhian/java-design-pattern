package creational.prototype.simple;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 原型
 */
interface Prototype {
    void add(String... values);                                         // 此处用来验证引用类型, 引用地址默认只拷贝引用

    Prototype copy() throws Exception;                                 // 定义拷贝方法
}

/**
 * 具体原型, 浅拷贝, 使用 Object#clone() 实现
 */
class ShallowConcretePrototype implements Prototype, Cloneable {
    private final String val;
    private final List<String> list = new ArrayList<>();

    public ShallowConcretePrototype(String val, String... values) {
        this.val = val;
        this.add(values);
    }

    @Override
    public void add(String... values) {
        Collections.addAll(list, values);
    }

    @Override
    public Prototype copy() throws CloneNotSupportedException {
        return (Prototype) super.clone(); // Object#clone(), 仅拷贝栈内存
    }

    @Override
    public String toString() {
        return "{val=" + val + ", list=" + list + '}';
    }
}

/**
 * 具体原型, 深拷贝, 使用序列化二进制流实现
 */
class DeepConcretePrototype implements Prototype, Serializable {
    private final String val;
    private final List<String> list = new ArrayList<>();

    public DeepConcretePrototype(String val, String... values) {
        this.val = val;
        this.add(values);
    }

    @Override
    public void add(String... values) {
        Collections.addAll(list, values);
    }

    @Override
    public Prototype copy() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);               // 将对象写出到二进制流中
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Prototype) objectInputStream.readObject();  // 从二进制流中读取
    }

    @Override
    public String toString() {
        return "{val=" + val + ", list=" + list + '}';
    }
}

/**
 * @author yuzhian
 */
public class PrototypeDemo {
    public static void main(String[] args) throws Exception {
        // 浅克隆
        Prototype s1 = new ShallowConcretePrototype("a", "x1y2");
        Prototype s2 = s1.copy();
        // 深克隆
        Prototype d1 = new DeepConcretePrototype("b", "x2y1");
        Prototype d2 = d1.copy();

        System.out.println(s1 == s2);           // 连等比较的是栈内存, 即基本类型和引用地址(指针), 因此浅克隆即使指向相同也不等.
        s1.add("x3y4");
        System.out.println(s1 + " / " + s2);    // 只修改 s1, s2 也会更改, 因为浅克隆仅拷贝栈内存, 仍共享同一份堆内存对象.

        System.out.println(d1 == d2);           // 深克隆堆栈全部克隆.
        d1.add("x4y3");
        System.out.println(d1 + " / " + d2);    // 两个变量各自指向自己的那一份.
    }
}
