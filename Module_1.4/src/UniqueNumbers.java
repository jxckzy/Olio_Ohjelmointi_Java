import java.util.Scanner;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        // Tehtävänannosta:
        // Uusi lista uniikille numeroille
        int[] uniqueNumbers = new int[size];
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            int current = numbers[i];
            boolean alreadyAdded = false;

            // Tarkistetaan jos numero on jo olemassa listassa
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueNumbers[j] == current) {
                    alreadyAdded = true;
                    break;
                }
            }
            if (!alreadyAdded) {
                uniqueNumbers[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Laitetaan näkyviin pelkästään uniikit luvut
        System.out.println();
        System.out.println("The array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(uniqueNumbers[i] + " ");
        }
        System.out.println();
    }
}