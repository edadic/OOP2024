package week10.labs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

// Student Class
class Student {
    private String name;
    private String id;
    private List<Integer> grades;

    public Student(String name, String id, List<Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", ID: " + id + ", Grades: " + grades);
    }
}

// GradeAnalyzer Class
class GradeAnalyzer {
    private List<Integer> grades;

    public GradeAnalyzer(List<Integer> grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void printSummary() {
        System.out.println("Average grade: " + calculateAverage());
    }
}

// Start Class
class Start {
    public static void main(String[] args) throws Exception {
        Student student = new Student("John", "12345", Arrays.asList(85, 90, 78));
        GradeAnalyzer analyzer = new GradeAnalyzer(Arrays.asList(85, 90, 78));

        // Reflection for Student
        System.out.println("Student Class Reflection:");
        for (Field field : Student.class.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ": " + field.get(student));
        }

        for (Method method : Student.class.getDeclaredMethods()) {
            if (method.getName().startsWith("print")) {
                method.invoke(student);
            }
        }

        // Reflection for GradeAnalyzer
        System.out.println("\nGradeAnalyzer Class Reflection:");
        for (Field field : GradeAnalyzer.class.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ": " + field.get(analyzer));
        }

        for (Method method : GradeAnalyzer.class.getDeclaredMethods()) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                if (method.getReturnType() != void.class) {
                    System.out.println(method.getName() + ": " + method.invoke(analyzer));
                } else {
                    method.invoke(analyzer);
                }
            }
        }
    }
}

