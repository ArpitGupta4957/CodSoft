import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This program calculates the average marks and corresponding grades of students.
 */
public class stu_grd_calc {
    /**
     * This method returns the grade of a student based on their marks.
     *
     * @param marks the student's marks
     * @return the corresponding grade
     */
    private static String getGrade(int marks) {
        if (marks >= 0 && marks < 30) {
            return "F";
        } else if (marks >= 30 && marks < 45) {
            return "E";
        } else if (marks >= 45 && marks < 60) {
            return "D";
        } else if (marks >= 60 && marks < 75) {
            return "C";
        } else if (marks >= 75 && marks < 85) {
            return "B";
        } else {
            return "A";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a Scanner object to read user input
        Map<Integer, String> gradeMap = new HashMap<>(); // create a HashMap to store marks and grades

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt(); // read the number of students

        int totalMarks = 0; // initialize a variable to store the total marks
        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter the marks of student : ");
            int marks = scanner.nextInt(); // read the marks of a student

            String grade = getGrade(marks); // get the grade of the student
            gradeMap.put(marks, grade); // store the marks and grade in the HashMap

            totalMarks += marks; // add the marks to the total marks
        }

        double averageMarks = (double) totalMarks / numStudents; // calculate the average marks
        System.out.printf("The average marks of the students is: %.2f%n", averageMarks); // print the average marks

        System.out.println("The grades of the students are: ");
        for (Integer marks : gradeMap.keySet()) { // iterate over the HashMap to print the marks and grades
            System.out.println(marks + " : " + gradeMap.get(marks));
        }
    }
}