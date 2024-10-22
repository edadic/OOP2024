package week4.labs.people;

import java.util.ArrayList;
import java.util.List;

class Person {

    private String name;
    private String address;
    private int age;
    private String country;


    public Person(String name, String address, int age, String country) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name + "\n  " + this.address;
    }
}

class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int salary, int age, String country) {
        super(name, address, age, country);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  salary " + this.salary + " euro/month";
    }
}

class Student extends Person {

    private int credits;
    private int student_id;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, String address, String country, int age, int student_id) {
        super(name, address, age, country);
        this.student_id = student_id;
        this.grades= new ArrayList<>();
        this.credits = 0;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void study() {
        this.credits++;
    }

    public void addGrade(int grade) {
        if(grade >= 0 && grade <= 5) {
            this.grades.add(grade);
        } else {
            System.out.println("Invalid grade");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n  student_id  " + this.student_id + "\n  grades " + this.grades;
    }
}

