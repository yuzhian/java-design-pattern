package structural.facade.simple;

/**
 * 子系统角色, 可能存在复杂的互相调用
 */
class SubSystem {
    public <T> String getSimpleName(T t) {
        return t.getClass().getSimpleName();
    }
}

class SubSystem1 {
    public SubSystem2 getSubSystem2() {
        return new SubSystem2();
    }
}

class SubSystem2 {
}

/**
 * 外观角色
 */
class Facade {
    public void printAll() {
        SubSystem subSystem = new SubSystem();
        SubSystem1 subSystem1 = new SubSystem1();
        SubSystem2 subSystem2 = subSystem1.getSubSystem2();
        System.out.printf("外观角色: %s, 子系统: [%s, %s, %s]%n",
                subSystem.getSimpleName(this),
                subSystem.getSimpleName(subSystem),
                subSystem.getSimpleName(subSystem1),
                subSystem.getSimpleName(subSystem2)
        );
    }
}

/**
 * @author yuzhian
 */
public class FacadeDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.printAll();
    }
}
