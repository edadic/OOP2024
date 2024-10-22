package week4.labs.task2;

public class Shape {
    private String color;
    private FillType filled;

    public Shape(String color, FillType filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FillType getFilled() {
        return filled;
    }

    public void setFilled(FillType filled) {
        this.filled = filled;
    }

    public String displayInfo (){
        return this.color + "\n" + this.getFilled();
    }

    public double getArea() {
        return 0;
    }

    public String toString() {
        return "Color: " + this.color + "\nFilled: " + this.filled;
    }
}
