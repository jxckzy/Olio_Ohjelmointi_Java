import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Weight (g): ");
        String input = scanner.nextLine();
        double grams = Double.parseDouble(input);

        // Muunnetaan koko paino ensin luodiksi
        // Saadaan luodin kokonaismäärän
        double total_Luoti = grams / 13.28;

        // 1 leiviskä = 20 naulaa = 20 * 32 = 640 luotia
        // Saadaan määrän mahdollisia leivisköitä
        int leiviska = (int) (total_Luoti / 640);
        double remaining = total_Luoti - leiviska * 640;

        // 1 naula = 32 luotia
        // Saadaan muunnettua jäljellä olevaa luotia
        int naula = (int) (remaining / 32);
        double luoti = remaining - naula * 32;

        System.out.printf("%s grams is %d leiviska, %d naula, and %.2f luoti.%n",
                input, leiviska, naula, luoti);
    }
}