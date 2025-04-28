package Interface;

interface Vehicle {
    void start();
  }
    class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike started. Ready to ride!");
    }
 }

