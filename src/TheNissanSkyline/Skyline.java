package TheNissanSkyline;
// Abstract Class
abstract class NissanSkyline {
    protected String model;
    protected String engineType = "V6 Twin Turbo";

    public NissanSkyline(String model) {
        this.model = model;
    }

    public void showBrand() {
        System.out.println("Brand: Nissan");
    }

    public void showEngine() {
        System.out.println("Engine: " + engineType);
    }

    public abstract void accelerate();
    public abstract void topSpeed();
}

// Subclass 1
class GTR extends NissanSkyline {
    public GTR() {
        super("GT-R");
    }

    @Override
    public void accelerate() {
        System.out.println(model + " accelerates from 0-100 km/h in 3.5 seconds.");
    }

    @Override
    public void topSpeed() {
        System.out.println(model + " top speed: 315 km/h.");
    }
}

// Subclass 2
class GTRNismo extends NissanSkyline {
    public GTRNismo() {
        super("GT-R NISMO");
    }

    @Override
    public void accelerate() {
        System.out.println(model + " accelerates from 0-100 km/h in 2.9 seconds.");
    }

    @Override
    public void topSpeed() {
        System.out.println(model + " top speed: 330 km/h.");
    }
}

// Interface
interface RacingFeatures {
    void enableTurboBoost();
    void enableTelemetry();
}

// External Modded Class
class SkylineRaceMod implements RacingFeatures {
    @Override
    public void enableTurboBoost() {
        System.out.println("Turbo Boost enabled: Additional 150 HP added.");
    }

    @Override
    public void enableTelemetry() {
        System.out.println("Telemetry system online: Monitoring speed, RPM, and G-forces.");
    }
}

// Main Class
public class Skyline {
    public static void main(String[] args) {
        NissanSkyline baseModel = new GTR();
        baseModel.showBrand();
        baseModel.showEngine();
        baseModel.accelerate();
        baseModel.topSpeed();

        System.out.println("------");

        NissanSkyline proModel = new GTRNismo();
        proModel.showBrand();
        proModel.showEngine();
        proModel.accelerate();
        proModel.topSpeed();

        System.out.println("------");

        RacingFeatures modCar = new SkylineRaceMod();
        modCar.enableTurboBoost();
        modCar.enableTelemetry();
    }
}

