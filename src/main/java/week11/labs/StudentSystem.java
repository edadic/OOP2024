package week11.labs;

import week11.labs.exceptions.EmptyStudentListException;
import week11.labs.exceptions.InvalidStudentDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentSystem {

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public StudentSystem(String filename) {
        try {
            this.students = readStudents(filename);
            validateStudentData(this.students);
        } catch (IOException | InvalidStudentDataException e) {
            this.students = new ArrayList<>();
            System.out.println("Unable to read from file or invalid data.");
        }
    }

    public StudentSystem(List<Student> students) {
        this.students = students;
        try {
            validateStudentData(this.students);
        } catch (InvalidStudentDataException e) {
            this.students = new ArrayList<>();
            System.out.println("Invalid data.");
        }
    }

    public static List<Student> readStudents(String filename) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        List<String> lines = bufferedReader.lines().toList();
        for (String line : lines) {
            String[] studentParts = line.split(",");
            Student s = new Student(Integer.parseInt(studentParts[0]),
                    studentParts[1],
                    studentParts[2],
                    studentParts[3],
                    Double.parseDouble(studentParts[4])
            );
            students.add(s);
        }
        bufferedReader.close();
        return students;
    }

    public int noOfStudents() {
        return students.size();
    }

    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    public Student getHighestGPAStudent() throws EmptyStudentListException {
        if (!this.students.isEmpty()) {
            return students.stream()
                    .max((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()))
                    .orElseThrow(() -> new EmptyStudentListException("List of students is empty."));
        } else {
            throw new EmptyStudentListException("List of students is empty.");
        }
    }

    public Student getLongestNameStudent() throws EmptyStudentListException {
        if (!this.students.isEmpty()) {
            return students.stream()
                    .max((s1, s2) -> Integer.compare(s1.getName().length(), s2.getName().length()))
                    .orElseThrow(() -> new EmptyStudentListException("List of students is empty."));
        } else {
            throw new EmptyStudentListException("List of students is empty.");
        }
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataException {
        for (Student student : students) {
            if (student.getGpa() < 6 || student.getGpa() > 10) {
                throw new InvalidStudentDataException("Read data has invalid rows.");
            }
        }
    }
}