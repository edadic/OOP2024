package week2.labs;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number n: ");

        int n = Integer.parseInt(scanner.nextLine());

        int sum=0;
        for(int i = 0; i<=n; i++){
            sum+=(int) Math.pow(2,i);
        }
        System.out.println("The sum of the powers of number 2 until " + n + " is: " + sum);
    }
}
