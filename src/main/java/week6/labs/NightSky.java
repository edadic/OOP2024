package week6.labs;

import java.util.Random;

public class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;

    public NightSky(double density) {
        this(density, 20, 10);
    }

    public NightSky(int width, int height) {
        this(0.1, width, height);
    }

    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
        this.starsInLastPrint = 0;
    }

    public void printLine() {
        Random random = new Random();
        for(int i = 0; i<this.width; i++) {
            if(random.nextDouble()<=this.density) {
                System.out.print("*");
                this.starsInLastPrint++;
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void print() {
        this.starsInLastPrint = 0;

        for(int i = 0; i<this.height; i++) {
            printLine();
        }
    }

    public int starsInLastPrint() {
        return this.starsInLastPrint;
    }

    public static void main(String[] args) {
        NightSky NightSky = new NightSky(0.1, 40, 10);
        NightSky.print();
        System.out.println("Number of stars: " + NightSky.starsInLastPrint());
        System.out.println();

        NightSky nightSky2 = new NightSky(8,4);
        nightSky2.print();
        System.out.println("Number of stars: " + nightSky2.starsInLastPrint());
        System.out.println();
    }
}
