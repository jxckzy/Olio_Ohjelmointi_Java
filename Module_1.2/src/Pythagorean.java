import java.util.Scanner;

public class Pythagorean {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the first leg:");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the length of the second leg:");
        double b = Double.parseDouble(scanner.nextLine());

        double hypotenuse = Math.sqrt(a * a + b * b);

        System.out.printf("The length of the hypotenuse is %.1f%n", hypotenuse);
    }
}