package week2.labs;

public class task9 {
    public static void main (String[] args) {
        drawNumbersPiramid(5);
    }

    public static void drawNumbersPiramid(int rows) {
        for (int i = 1; i<=rows; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
