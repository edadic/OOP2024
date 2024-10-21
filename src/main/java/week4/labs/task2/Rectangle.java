package week4.labs.task2;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(String color, FillType filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String displayInfo(){
        return this.getColor() + "\n" + getFilled();
    }

    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWidth: " + this.getWidth() + "\nHeight: "+ this.getHeight() + "\nArea: "+ this.getArea();
    }
}
