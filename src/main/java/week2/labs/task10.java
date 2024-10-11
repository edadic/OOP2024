package week2.labs;

import java.util.Scanner;

public class task10 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToBeGuessed = (int)(Math.random() * 101);
        int numberOfTries = 0;
        int currentGuess=-1;

        System.out.print("Guess the number: ");

        while(currentGuess != numberToBeGuessed){
            currentGuess = Integer.parseInt(scanner.nextLine());
            numberOfTries++;
            if(currentGuess < numberToBeGuessed){
                System.out.println("Higher!    -   This is your " + numberOfTries + ". guess!");
            } else if(currentGuess > numberToBeGuessed){
                System.out.println("Lower!    -   This is your " + numberOfTries + ". guess!");
            } else {
                System.out.println("You are correct!");
                System.out.println("You made " + numberOfTries + " guesses!");
            }
        }
    }
}
