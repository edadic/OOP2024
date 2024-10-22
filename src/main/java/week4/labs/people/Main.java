package week4.labs.people;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
    List<Person> people = new ArrayList<Person>();
    people.add(new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200, 45, "Finland"));
    Student student = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki","Finland", 20, 12345);
    student.addGrade(3);
    student.addGrade(5);
    people.add(student);

    printDepartment(people);
}
    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
}


