package week2.labs;

import java.util.Scanner;

public class task6 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of times to print the message:");
        int printingTimes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < printingTimes; i++) {
            printMessage();
        }
    }

    public static void printMessage() {
        System.out.println("In the beginning there were the swamp, the hoe and Java.");
    }
}
