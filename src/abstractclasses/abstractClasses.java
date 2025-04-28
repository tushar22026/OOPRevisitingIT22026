package abstractclasses;

abstract class abstractClasses {
    abstract void startEngine();

    void stopEngine() {
        System.out.println("Engine stopped.");
    }
}

class Car extends abstractClasses {
    void startEngine() {
        System.out.println("Car engine started. Vroom Vroom!");
    }
}
