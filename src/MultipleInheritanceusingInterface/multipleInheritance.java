package MultipleInheritanceusingInterface;

    interface Jumpable {
        void jump();
    }

    class Athlete implements Runnable, Jumpable {
        public void run() {
            System.out.println("Athlete is running...");
        }

        public void jump() {
            System.out.println("Athlete is jumping...");
        }
    }
