package abstractclasses;
// Interface
interface Flyable {
    void fly();
}
// Abstract class
abstract class FlyingVehicle {
    String model;
    // Constructor
    public FlyingVehicle(String model) {
        this.model = model;
    }

    // Abstract method
    abstract void takeOff();

    // Concrete method
    public void showModel() {
        System.out.println("Model: " + model);
    }
}
// Subclass
class Airplane extends FlyingVehicle implements Flyable {
    public Airplane(String model) {
        super(model);
    }

    @Override
    public void fly() {
        System.out.println("Airplane is flying at high altitude.");
    }

    @Override
    void takeOff() {
        System.out.println("Airplane takes off from the runway.");
    }
}

// Subclass
class Helicopter extends FlyingVehicle implements Flyable {
    public Helicopter(String model) {
        super(model);
    }

    @Override
    public void fly() {
        System.out.println("Helicopter is flying at low altitude.");
    }

    @Override
    void takeOff() {
        System.out.println("Helicopter takes off vertically.");
    }
}

// Main class
public class FlightDemo {
    public static void main(String[] args) {
        FlyingVehicle plane = new Airplane("Boeing 747");
        plane.showModel();
        ((Flyable) plane).fly();
        plane.takeOff();

        System.out.println();

        FlyingVehicle copter = new Helicopter("Bell 206");
        copter.showModel();
        ((Flyable) copter).fly();
        copter.takeOff();
    }
}
