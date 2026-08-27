import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start value: ");
        int start = scanner.nextInt();

        System.out.print("Enter the end value: ");
        int end = scanner.nextInt();

        System.out.println("Prime numbers between " + start + " and " + end + ":");

        // Alusta loppuun asti tarkistetaan, jos prime vai ei
        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
        scanner.close();
    }

    // Metodi, jolla tarkistetaan luvut
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // prime täytyy olla suurempi, kuin 1
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // jos voi jakaa jotain muulla kuin 1:llä tai itsellään
            }
        }
        // muuten, return
        return true;
    }
}