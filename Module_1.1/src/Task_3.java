import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        int sum = first + second + third;
        int product = first * second * third;

        /*
            The reason why the average is wrong was because
            the average number was an integer and each number
            were integers as well. To fix that, we have to
            transform an integer into float number. In such case,
            we transform from int to double (module 1.2)
         */
        double average = (double) sum / 3;

        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);
    }
}