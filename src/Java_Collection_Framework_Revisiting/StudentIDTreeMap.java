package Java_Collection_Framework_Revisiting;

import java.util.*;

class Student {
    String name;
    int age;
    String department;

    Student(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

public class StudentIDTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Student> studentMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");

            System.out.print("Student ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Department: ");
            String dept = scanner.nextLine();

            Student student = new Student(name, age, dept);
            studentMap.put(id, student);
        }

        // Display all student details (sorted by ID)
        System.out.println("\nStudent Records (sorted by ID):");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }

        scanner.close();
    }
}

