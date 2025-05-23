package Java_Collection_Framework_Revisiting;
import java.util.*;
public class Arraylist {
        public static int findKthSmallest(ArrayList<Integer> list, int k) {
            Collections.sort(list);
            return list.get(k - 1); 
        }

        public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            System.out.println("Enter " + n + " numbers:");
            for (int i = 0; i < n; i++) {
                numbers.add(scanner.nextInt());
            }

            System.out.print("Enter value of k: ");
            int k = scanner.nextInt();

            if (k <= 0 || k > n) {
                System.out.println("Invalid k value.");
            } else {
                int result = findKthSmallest(numbers, k);
                System.out.println("The " + k + "th smallest element is: " + result);
            }
        }
    }
