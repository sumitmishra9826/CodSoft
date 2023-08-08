import java.util.Scanner;
import java.util.*;

public class StudentManagementSystemUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character after reading the integer choice.

            switch (choice) {
                case 1:
                    addStudent(scanner, sms);
                    break;
                case 2:
                    removeStudent(scanner, sms);
                    break;
                case 3:
                    searchStudent(scanner, sms);
                    break;
                case 4:
                    displayAllStudents(sms);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character after reading the integer roll number.

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student newStudent = new Student(name, rollNumber, grade);
        sms.addStudent(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter the roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character after reading the integer roll number.

        sms.removeStudent(rollNumber);
        System.out.println("Student with roll number " + rollNumber + " removed successfully!");
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter the roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character after reading the integer roll number.

        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Grade: " + student.getGrade());
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    private static void displayAllStudents(StudentManagementSystem sms) {
        System.out.println("\nList of all students:");
        List<Student> students = sms.getAllStudents();
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("------------------------");
        }
    }
}