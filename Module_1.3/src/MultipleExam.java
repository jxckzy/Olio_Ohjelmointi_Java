import java.util.Scanner;

public class MultipleExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean mastered = false; // jos päästään testin läpi, se poistuu ohjelmasta

        while (!mastered) {
            int score = 0;

            System.out.println("New set of 10 questions. Good luck!");
            System.out.println();

            for (int i = 1; i <= 10; i++) {
                // Generoidaan 2 lukua välillä 1 ja 10 kaavan avulla
                int factor1 = (int) (Math.random() * 10) + 1;
                int factor2 = (int) (Math.random() * 10) + 1;

                int correctAnswer = factor1 * factor2;

                System.out.print("Question " + i + ": " + factor1 + " x " + factor2 + " = ");
                int userAnswer = scanner.nextInt();
                // Tarkistetaan jos oikein
                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer was " + correctAnswer + ".");
                }
            }

            System.out.println();
            System.out.println("You scored " + score + " out of 10.");
            // Joku voi päästä tekstin läpi jos saa kaikki pisteet
            if (score == 10) {
                System.out.println("Congratulations! You have mastered the multiplication tables!");
                mastered = true;
            } else {
                System.out.println("Let's try another set of problems.");
                System.out.println();
            }
        }
        scanner.close();
    }
}