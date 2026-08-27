import java.util.Random;
import java.util.Scanner;

public class RandomNames {
    public static void main(String[] args) {
        String[] firstNames = {"Emma", "Liam", "Olivia", "Noah", "Ava", "Elijah", "Sophia", "Mateo"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // Asennetaan randomizer

        System.out.print("How many random names do you want to generate? ");
        int amount = scanner.nextInt();

        for (int i = 0; i < amount; i++) {
            // Tehtävänannosta
            int firstIndex = random.nextInt(firstNames.length);
            int lastIndex = random.nextInt(lastNames.length);

            String fullName = firstNames[firstIndex] + " " + lastNames[lastIndex];
            System.out.println(fullName);
        }

        scanner.close();
    }
}