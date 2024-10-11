package week2.labs;

public class task8 {
    public static void main (String[] args) {
        drawInvertedPyramid(10);
    }

    public static void drawInvertedPyramid(int rows) {
        for (int i = rows; i>=1; i--) {
            for (int j = 1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
