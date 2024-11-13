package week7.labs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

record EmployeeRecord(String name, String position, double salary, Date employmentDate) {

    public static EmployeeRecord createIntern(String name) {
        return new EmployeeRecord(name, "Intern", 1000, new Date());
    }

    public static List<EmployeeRecord> filterEmployeesOverFiveYears(List<EmployeeRecord> employees) {
        List<EmployeeRecord> result = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for(EmployeeRecord employee : employees) {
            LocalDate employmentDate = employee.employmentDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            if(currentDate.getYear() - employmentDate.getYear() >= 5) {
                result.add(employee);
            }
        }
        return result;
    }

    public static double calculateAverageSalary(List<EmployeeRecord> employees, String department) {
        double totalSalary = 0;
        int count = 0;
        for(EmployeeRecord employee :employees) {
            if(employee.position().equals(department)) {
                totalSalary+= employee.salary();
                count++;
            }
        }
        return totalSalary/count;
    }

    public static List<EmployeeRecord> findEmployeesByRole(List<EmployeeRecord> employees, String role) {
        List<EmployeeRecord> result = new ArrayList<>();
        for(EmployeeRecord employee : employees) {
            if(employee.position().equals(role)) {
                result.add(employee);
            }
        }
        return result;
    }
    public static void printEmployeeByRole (List<EmployeeRecord> employees, String role) {
        List<EmployeeRecord> employeesByRole = findEmployeesByRole(employees,role);
        for(EmployeeRecord employee : employeesByRole) {
            System.out.println(employee);
        }
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<EmployeeRecord> employees = new ArrayList<>();
        employees.add(new EmployeeRecord("Employee1", "Intern", 1000, new Date()));
        employees.add(new EmployeeRecord("Employee2", "Manager", 5000, new Date()));
        employees.add(new EmployeeRecord("Employee3", "Intern", 1000, new Date()));
        employees.add(new EmployeeRecord("Employee4", "Manager", 5000, new Date()));
        employees.add(new EmployeeRecord("Employee5", "Intern", 1000, new Date()));
        employees.add(new EmployeeRecord("Employee6", "Manager", 5000, new Date()));
        EmployeeRecord.createIntern("Employee7");

        List<EmployeeRecord> longWorkingEmployees = EmployeeRecord.filterEmployeesOverFiveYears(employees);
        System.out.println("Employees working more than 5 years: ");
        for(EmployeeRecord employee : longWorkingEmployees) {
            System.out.println(employee);
        }

        double averageSalary = EmployeeRecord.calculateAverageSalary(employees, "Manager");
        System.out.println("Average salary of Managers: " + averageSalary);

        System.out.println("Details of employees by role: ");
        EmployeeRecord.printEmployeeByRole(employees, "Intern");
    }
}
