public class Shape {

    public double calculateArea() {
        return 0;
    }
}


class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Area of Circle with radius " + radius + ": " + calculateArea();
    }
}


class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Area of Rectangle with width " + width + " and height " + height + ": " + calculateArea();
    }
}


class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Area of Triangle with base " + base + " and height " + height + ": " + calculateArea();
    }
}


class ShapeCalculator {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Triangle triangle = new Triangle(3.0, 8.0);

        Shape[] shapes = {circle, rectangle, triangle};

        System.out.println("Shape Calculator\n");

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}