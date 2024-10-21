package week4.labs.task2;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle("red", FillType.FILLED, 5);
        System.out.println("Circle: ");
        System.out.println(circle);

        Rectangle rectangle = new Rectangle("blue", FillType.NOT_FILLED, 5, 10);
        System.out.println("Rectangle: ");
        System.out.println(rectangle);


    }
}
