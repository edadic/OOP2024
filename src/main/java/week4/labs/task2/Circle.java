package week4.labs.task2;

public class Circle extends Shape {

    private double radius;

    public Circle(String color, FillType filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double calculateCircumference(double PI, double r) {
        return 2 * PI * r;
    }

    public double calculateCircumference(double r) {
        double PI = 3.14;
        return 2 * PI * r;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRadius: " + this.radius + "\nArea: " + this.getArea();
    }
}
