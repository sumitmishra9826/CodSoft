import java.util.*;
public class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    Scanner sc=new Scanner(System.in);

    public int getRollNumber() {
        int rollno;
        System.out.println("Enter the roll number");
        rollno=sc.nextInt();
        return rollno;

    }

    public String getName() {
        String name;
        System.out.println("Enter your name");
        name=sc.nextLine();
        return name;
    }

    public String getGrade() {
        String grade;
        System.out.println("Enter your Grade");
        grade = sc.nextLine();
        return grade;
    }
}