/**
 * Calculator acts as the Model in an MVC design.
 * It can sum positive integers. Negative integers are rejected.
 * This version contains several implementations of "add" side by side.
 * In real use you'd only keep one; they're all kept here so you can compare them.
 */
public class Calculator {

    private int value;

    public Calculator() {
        reset();
    }

    /**
     * Resets the calculator's value back to zero.
     */
    public void reset() {
        value = 0;
    }

    /**
     * Returns the current value of the calculator.
     * @return the current summed value
     */
    public int getValue() {
        return value;
    }

    // ---------------------------------------------------------------
    // Approach 1: "Signature only" — write just the method header,
    // and the body is filled in directly.
    // ---------------------------------------------------------------
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot add a negative number: " + number);
        }
        value += number;
    }

    // ---------------------------------------------------------------
    // Approach 2a: "Signature + first line" — you write the method
    // header and start the loop yourself; a for-loop is used to walk
    // through multiple numbers passed as varargs.
    // ---------------------------------------------------------------
    public void addAllFor(int... numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Cannot add a negative number: " + number);
            }
            value += number;
        }
    }

    // ---------------------------------------------------------------
    // Approach 2b: same method, manually rewritten to use a while-loop
    // instead of a for-loop, to see the equivalent control structure.
    // ---------------------------------------------------------------
    public void addAllWhile(int... numbers) {
        int i = 0;
        while (i < numbers.length) {
            int number = numbers[i];
            if (number < 0) {
                throw new IllegalArgumentException("Cannot add a negative number: " + number);
            }
            value += number;
            i++;
        }
    }

    // ---------------------------------------------------------------
    // Approach 3: "Comment-driven" — the method body is derived purely
    // from an English description of what it should do, written above it.
    //
    // Adds the given integer to the calculator's value.
    // If the number is negative, throws an IllegalArgumentException
    // instead of changing the value.
    // ---------------------------------------------------------------
    public void addFromComment(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot add a negative number: " + number);
        }
        value += number;
    }
}