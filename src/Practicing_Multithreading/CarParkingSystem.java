package Practicing_Multithreading;
import java.util.*;
public class CarParkingSystem {
    //RegistrarParking (Order)
    static class RegistrarParking {
        private final int carId;

        public RegistrarParking(int carId) {
            this.carId = carId;
        }

        public int getCarId() {
            return carId;
        }

        public void process() {
            System.out.println("Car " + carId + " is being parked...");
            try {
                Thread.sleep(1000); //Simulate parking time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Car " + carId + " has been parked.");
        }
    }
    //ParkingPool (OrderQueue)
    static class ParkingPool {
        private final Queue<RegistrarParking> orderQueue = new LinkedList<>();

        public synchronized void placeOrder(RegistrarParking order) {
            orderQueue.add(order);
            notifyAll(); // Notify all agents
        }

        public synchronized RegistrarParking takeOrder() {
            while (orderQueue.isEmpty()) {
                try {
                    wait(); // Wait until a new order is available
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            return orderQueue.poll();
        }
    }
    //ParkingAgent (Worker Thread)
    static class ParkingAgent extends Thread {
        private final ParkingPool pool;
        private final int agentId;
        private final int totalCars;
        private static int completedOrders = 0;

        public ParkingAgent(ParkingPool pool, int agentId, int totalCars) {
            this.pool = pool;
            this.agentId = agentId;
            this.totalCars = totalCars;
        }

        @Override
        public void run() {
            while (true) {
                RegistrarParking order = pool.takeOrder();
                if (order == null) break;

                System.out.println("Agent " + agentId + " is handling car " + order.getCarId());
                order.process();

                synchronized (ParkingAgent.class) {
                    completedOrders++;
                    if (completedOrders >= totalCars) {
                        System.out.println("All cars are parked.");
                        break;
                    }
                }
            }
        }
    }
    //MainClass (Driver)
    public static void main(String[] args) {
        ParkingPool pool = new ParkingPool();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of cars to park: ");
        int numberOfCars = scanner.nextInt();
        scanner.close();

        // Start 3 Parking Agents
        for (int i = 1; i <= 3; i++) {
            new ParkingAgent(pool, i, numberOfCars).start();
        }

        // Simulate car arrival
        for (int i = 1; i <= numberOfCars; i++) {
            RegistrarParking order = new RegistrarParking(i);
            pool.placeOrder(order);
            try {
                Thread.sleep(500); // Simulate arrival delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


