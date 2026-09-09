# Calculator (MVC Model)

This project implements a simple `Calculator` class that acts as the **Model**
in an MVC (Model-View-Controller) design. The calculator can sum positive
integers, one at a time, and keeps a running total that can be read out or
reset. Adding a negative integer is treated as an invalid operation and
throws an exception rather than silently corrupting the total.

The class is intentionally small and self-contained so it can be wrapped by
different Views and Controllers later (e.g. a console UI, a GUI, or a web
front end) without changing the underlying logic.

## The code

```java
/**
 * Calculator acts as the Model in an MVC design.
 * It can sum positive integers. Negative integers are rejected.
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
     * Adds a positive integer to the calculator's current value.
     *
     * @param number the integer to add; must not be negative
     * @throws IllegalArgumentException if number is negative
     */
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot add a negative number: " + number);
        }
        value += number;
    }

    /**
     * Returns the current value of the calculator.
     *
     * @return the current summed value
     */
    public int getValue() {
        return value;
    }
}
```

## How it works

The `Calculator` class stores its running total in a single private field,
`value`. Keeping this field private means the total can only be changed
through the class's own methods, which is what lets the class guarantee
that its value is never negative.

**Constructor.** When a `Calculator` is created, its constructor immediately
calls `reset()`, so a brand-new calculator always starts at `0` instead of
relying on Java's default `int` value.

**`reset()`.** This method sets `value` back to `0`. It's used both by the
constructor and whenever the caller wants to start a new calculation from
scratch, without creating a new `Calculator` object.

**`add(int number)`.** This is the core method. It first checks whether the
given `number` is negative. If it is, the method throws an
`IllegalArgumentException` with a message identifying the offending value,
and `value` is left unchanged. If the number is zero or positive, it is
added directly to `value`. Because the check happens before the addition,
an invalid call can never leave the calculator in a partially-updated or
inconsistent state.

**`getValue()`.** This is a simple getter that returns the current total.
As the Model in an MVC setup, this is the method a View or Controller would
call to display the calculator's current state to the user, without ever
touching the private `value` field directly.

**Why throw an exception instead of ignoring negative input?** Silently
ignoring bad input (e.g. just skipping negative numbers) would hide bugs in
whatever code calls the calculator. Throwing an exception makes the error
visible immediately, at the point where the invalid value was introduced,
which is easier to debug than discovering later that a total is wrong.

## Running it

A temporary `Main` class is included to exercise the calculator manually:

```java
Calculator calculator = new Calculator();
calculator.add(5);
calculator.add(10);
System.out.println(calculator.getValue()); // 15
```

Compile and run with:

```bash
javac Calculator.java Main.java
java Main
```
