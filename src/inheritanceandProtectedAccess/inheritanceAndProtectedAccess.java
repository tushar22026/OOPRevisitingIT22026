package inheritanceandProtectedAccess;

public class inheritanceAndProtectedAccess {
        protected String name = "Bird";
        void fly() {
            System.out.println(name + " is flying in the sky.");
        }
    }
    class Sparrow extends inheritanceAndProtectedAccess {
        void sing() {
            System.out.println(name + " singing sweetly!");
        }
    }
