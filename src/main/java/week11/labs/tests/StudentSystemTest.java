package week11.labs.tests;

import org.junit.Test;
import week11.labs.Student;
import week11.labs.StudentSystem;
import week11.labs.exceptions.EmptyStudentListException;
import week11.labs.exceptions.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentSystemTest {
    @Test
    public void testIfStudentPresent() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        assertNotNull("Student list should not be null",studentSystem.getStudents());
    }

    @Test
    public void testStudentWithId100() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        assertFalse(studentSystem.getStudentById(100).isPresent());
    }

    @Test
    public void testHighestGPAStudent() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        assertEquals(9.8, studentSystem.getHighestGPAStudent().getGpa(), 0.01);
    }

    @Test
    public void testExceptionForEmptyStudentList() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/empty.csv");
        assertThrows(EmptyStudentListException.class, studentSystem::getHighestGPAStudent);
    }

    @Test
    public void testExceptionMessageForEmptyStudentList() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/empty.csv");
        EmptyStudentListException exception = assertThrows(EmptyStudentListException.class, studentSystem::getHighestGPAStudent);
        assertEquals("List of students is empty.", exception.getMessage());
    }

    @Test
    public void testNamesArray() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        List<String> actualNames = studentSystem.getStudents().stream()
                .limit(5)
                .map(Student::getName)
                .toList();

        List<String> expectedNames = List.of("Camila Wood",
                "Alexander Thompson",
                "Liam Taylor", "Evelyn Jenkins",
                "Michael Jackson");
        assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testSize() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        assertEquals(70, studentSystem.noOfStudents());
    }

    @Test
    public void testLargestName() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        Student largestNameStudent = studentSystem.getLongestNameStudent();
        String expectedName = "Benjamin Richardson";
        assertEquals(expectedName, largestNameStudent.getName());
    }

    @Test
    public void testStudents() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        Student highestGPAStudent = studentSystem.getHighestGPAStudent();
        Student longestNameStudent = studentSystem.getLongestNameStudent();
        assertNotSame(highestGPAStudent, longestNameStudent);
    }

    @Test
    public void testSameStudent() {
        StudentSystem studentSystem = new StudentSystem("/Users/eldardadic/Desktop/OOP2024/src/main/java/week11/labs/tests/Students Data.csv");
        Student highestGPAStudent = studentSystem.getHighestGPAStudent();
        Optional<Student> studentWithId12 = studentSystem.getStudentById(12);
        assertSame(studentWithId12.orElse(null), highestGPAStudent);
    }
}