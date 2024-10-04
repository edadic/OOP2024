package week1;

import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        if (firstNumber > secondNumber) {
            System.out.println("Number " + firstNumber + " is greater than number " + secondNumber  + ".");
        }
        else if (firstNumber < secondNumber) {
            System.out.println("Number " + secondNumber + " is greater than number " + firstNumber  + ".");
        }
        else {
            System.out.println("Numbers are equal.");
        }
    }
}
