package week1;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("The sum of the numbers is: " + (firstNumber + secondNumber));

    }
}
