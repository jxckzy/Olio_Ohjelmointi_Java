/**
 * Temporary main class used to manually test all the Calculator
 * "add" variants side by side.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Approach 1: single-number add()
        calculator.add(5);
        calculator.add(10);
        calculator.add(2);
        System.out.println("Approach 1 (add): 5 + 10 + 2 = " + calculator.getValue());

        // Approach 2a: for-loop over varargs
        calculator.reset();
        calculator.addAllFor(1, 2, 3, 4);
        System.out.println("Approach 2a (addAllFor): 1+2+3+4 = " + calculator.getValue());

        // Approach 2b: while-loop over varargs
        calculator.reset();
        calculator.addAllWhile(1, 2, 3, 4);
        System.out.println("Approach 2b (addAllWhile): 1+2+3+4 = " + calculator.getValue());

        // Approach 3: comment-driven add
        calculator.reset();
        calculator.addFromComment(7);
        calculator.addFromComment(8);
        System.out.println("Approach 3 (addFromComment): 7 + 8 = " + calculator.getValue());

        // Exception handling check
        try {
            calculator.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}