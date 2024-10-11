package week2.labs;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the last number: ");
        int lastNumber = Integer.parseInt(scanner.nextLine());

        if (firstNumber <= lastNumber) {
            int currentNumber = firstNumber + 1;
            while (currentNumber < lastNumber) {
                System.out.println(currentNumber);
                currentNumber++;
            }
        } else {
            System.out.print(firstNumber);
            System.out.println(lastNumber);
            }
        }
    }
