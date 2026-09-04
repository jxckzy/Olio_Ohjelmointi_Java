class ShapeColor {
    private String color;   // parent saa color muuttujan

    public ShapeColor(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return 0;
    }

    public String getColor() {
        return color;
    }
}


class CircleColor extends ShapeColor {
    private double radius;

    public CircleColor(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Area of Circle with radius " + radius + ", color " + getColor() + ": " + calculateArea();
    }
}


class RectangleColor extends ShapeColor {
    private double width;
    private double height;

    public RectangleColor(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Area of Rectangle with width " + width + " and height " + height + ", color " + getColor() + ": " + calculateArea();
    }
}


class TriangleColor extends ShapeColor {
    private double base;
    private double height;

    public TriangleColor(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Area of Triangle with base " + base + " and height " + height + ", color " + getColor() + ": " + calculateArea();
    }
}


public class ShapeWithColor {
    public static void main(String[] args) {
        CircleColor circle = new CircleColor(5.0, "Red");
        RectangleColor rectangle = new RectangleColor(4.0, 6.0, "Blue");
        TriangleColor triangle = new TriangleColor(3.0, 8.0, "Green");

        ShapeColor[] shapes = {circle, rectangle, triangle};

        System.out.println("Shape Calculator\n");

        for (ShapeColor shape : shapes) {
            System.out.println(shape);
        }
    }
}