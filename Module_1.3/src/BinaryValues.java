import java.util.Scanner;

public class BinaryValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        int decimal = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            char bit = binary.charAt(i);
            int bitValue = bit - '0'; // Muunnetaan merkki '0' tai '1' sen kokonaislukuarvoksi
            int power = length - 1 - i; // Sijainti oikealta vasemmalle (merkitsevin bitti ensin)
            decimal += bitValue * Math.pow(2, power); // Decimaalia saadaan 2^x + muut etc...
        }

        System.out.println("The decimal equivalent is: " + decimal);

        scanner.close();
    }
}
