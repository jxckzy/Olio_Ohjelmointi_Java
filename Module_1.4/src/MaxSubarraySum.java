import java.util.Scanner;

public class MaxSubarraySum {
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

        int maxSum = Integer.MIN_VALUE; // Suurin löydetty summa (alustetaan pienimpään mahdolliseen arvoon)
        int bestStart = 0; // Alkuindeksi
        int bestEnd = 0;   // Loppuindeksi

        // Käydään läpi kaikki mahdolliset subarrays
        // Käytetään samalla bruteforce-algoritmia
        for (int start = 0; start < size; start++) {
            int sum = 0;
            for (int end = start; end < size; end++) {
                sum += numbers[end];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestStart = start;
                    bestEnd = end;
                }
            }
        }

        System.out.println();
        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Integers: " + (bestStart + 1) + "-" + (bestEnd + 1));
    }
}