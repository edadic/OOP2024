package week2.labs;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the second number: ");
        int secondNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the third number: ");
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int sum = firstNumber + secondNumber + thirdNumber;
        System.out.println("The sum of the three numbers is: " + sum);
    }
}
