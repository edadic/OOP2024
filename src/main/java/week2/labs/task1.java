package week2.labs;

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String correctPassword = "password";

        while (true) {
            System.out.println("Enter password ");
            String password = scanner.nextLine();
            if(password.equals(correctPassword)) {
                System.out.println("Right!!!    Secret is 'sdfbskhjdbfsd'");
                break;
            }
            else {
                continue;
            }
        }

    }
}
