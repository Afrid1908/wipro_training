package day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceSystem {
    public static void main(String[] args) {
        Map<String, Boolean> attendance = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Is the student present? (P/A): ");
                    String input = sc.nextLine().trim().toLowerCase();
                    boolean isPresent = input.equals("p");

                    attendance.put(name, isPresent);
                    System.out.println("Marked " + name + " as " + (isPresent ? "Present" : "Absent"));
                    break;

                case 2:
                    System.out.println("\n--- Attendance List ---");
                    if (attendance.isEmpty()) {
                        System.out.println("No records yet.");
                    } else {
                        attendance.forEach((student, status) ->
                            System.out.println(student + " - " + (status ? "Present" : "Absent"))
                        );
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!!!");
            }
        }
    }
}

