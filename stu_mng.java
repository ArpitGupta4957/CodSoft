
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class stu_mng {
    private String name;
    private int rollNumber;
    private String grade;

    public stu_mng(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementSystem {
    private List<stu_mng> students;
    private static final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        loadStudentsFromFile();
    }

    /**
     * Add the details of students in the system.
    */
    public void addStudent(stu_mng student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully.");
    }

    /**
     * Remove the details of students in the system.
     */
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        saveStudentsToFile();
        System.out.println("Student removed successfully.");
    }

    /**
     * Search the details of students in the system.
     */
    public stu_mng searchStudent(int rollNumber) {
        for (stu_mng student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    /**
     * Displays the details of all students in the system.
     */
    public void displayAllStudents() {
        System.out.println("All Students:");
        for (stu_mng student : students) {
            if (student != null) {
                System.out.println("Name: " + student.getName() +
                        ", Roll Number: " + student.getRollNumber() +
                        ", Grade: " + student.getGrade());
            }
        }
    }

    /**
     * Loads students from a file into memory.
     */
    @SuppressWarnings("unchecked")
    private void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<stu_mng>) ois.readObject();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Saves students to a file.
     */
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();

                    System.out.print("Enter grade: ");
                    String grade = scanner.next();

                    stu_mng newStudent = new stu_mng(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    sms.removeStudent(removeRollNumber);
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    stu_mng foundStudent = sms.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent.getName());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}