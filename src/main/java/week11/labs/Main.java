package week11.labs;

import week11.labs.exceptions.EmptyStudentListException;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");

        System.out.println("Number of students: " + studentSystem.noOfStudents());

        try {
            Student highestGPAStudent = studentSystem.getHighestGPAStudent();
            System.out.println("Student with the highest GPA: " + highestGPAStudent);
        } catch (EmptyStudentListException e) {
            System.out.println(e.getMessage());
        }

        try {
            Student longestNameStudent = studentSystem.getLongestNameStudent();
            System.out.println("Student with the longest name: " + longestNameStudent);
        } catch (EmptyStudentListException e) {
            System.out.println(e.getMessage());
        }

        int studentId = 12;
        Optional<Student> studentById = studentSystem.getStudentById(studentId);
        studentById.ifPresentOrElse(
                student -> System.out.println("Student with ID " + studentId + ": " + student),
                () -> System.out.println("Student with ID " + studentId + " not found")
        );
    }
}