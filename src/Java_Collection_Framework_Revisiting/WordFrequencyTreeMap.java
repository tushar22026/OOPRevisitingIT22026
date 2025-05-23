package Java_Collection_Framework_Revisiting;

import java.util.*;

public class WordFrequencyTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> freqMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String line = scanner.nextLine().toLowerCase();
        String[] words = line.split("\\W+");

        for (String word : words) {
            if (!word.isEmpty()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
