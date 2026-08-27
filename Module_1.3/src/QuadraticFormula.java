import java.util.Scanner;

public class QuadraticFormula {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ensin kysytään 3 kerrointa
        System.out.println("Enter value a of your quadratic formula: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter value b of your quadratic formula: ");
        double b = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter value c of your quadratic formula: ");
        double c = Double.parseDouble(scanner.nextLine());

        // Katsotaan diskriminantin avulla jos ratkaisuja on edes olemassa
        double discriminant = b*b - 4*a*c;

        if (discriminant < 0)
            System.out.println("No real roots");
        else if (discriminant == 0) {
            double root = -b / (2*a);
            System.out.println("Root: " + root);
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2*a);
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        }
    }
}
