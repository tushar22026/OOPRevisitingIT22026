package Encapsulation;

public class encapsulation {
        private double balance;

        public void deposit(double amount) {
            if(amount > 0) balance += amount;
        }

        public double getBalance() {
            return balance;
        }
    }
