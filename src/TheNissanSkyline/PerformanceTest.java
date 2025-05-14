package TheNissanSkyline;

interface MyInterface {
    void doWork();
}

abstract class MyAbstractClass {
    abstract void doWork();
}

class InterfaceImpl implements MyInterface {
    public void doWork() {
        // Simulate work
        int x = 0;
        for (int i = 0; i < 100; i++) {
            x += i;
        }
    }
}

class AbstractImpl extends MyAbstractClass {
    public void doWork() {
        // Simulate work
        int x = 0;
        for (int i = 0; i < 100; i++) {
            x += i;
        }
    }
}

public class PerformanceTest {
    public static void main(String[] args) {
        MyInterface iObj = new InterfaceImpl();
        MyAbstractClass aObj = new AbstractImpl();

        long startTime, endTime;

        // Interface test
        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            iObj.doWork();
        }
        endTime = System.nanoTime();
        System.out.println("Interface method time: " + (endTime - startTime) + " ns");

        // Abstract class test
        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            aObj.doWork();
        }
        endTime = System.nanoTime();
        System.out.println("Abstract class method time: " + (endTime - startTime) + " ns");
    }
}

