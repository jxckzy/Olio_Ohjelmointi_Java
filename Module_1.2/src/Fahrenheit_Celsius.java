import java.util.Scanner;

public class Fahrenheit_Celsius {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the temperature in Fahrenheit:");

        double fahrenheit = Double.parseDouble(scanner.nextLine());
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;

        System.out.printf("The temperature in Celsius is %.1f%n", celsius);
    }
}