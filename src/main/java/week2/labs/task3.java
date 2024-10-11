package week2.labs;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int number;

        while (true) {
            System.out.print("Enter a number: ");
            number = Integer.parseInt(scanner.nextLine());
            sum+=number;
            if (number == 0) {
                break;
            }
            System.out.println("The sum of the numbers is: " + sum);
        }
    }
}
