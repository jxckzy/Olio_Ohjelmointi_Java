import java.io.*;

public class FibonacciSequence {
    private static final int LAST_INDEX = 60;
    private static final String FILE_NAME = "fibonacci.csv";
    private static long[] generateFibonacci() {
        long[] sequence = new long[FibonacciSequence.LAST_INDEX + 1];
        sequence[0] = 0;
        if (FibonacciSequence.LAST_INDEX >= 1) {
            sequence[1] = 1;
        }
        for (int i = 2; i <= FibonacciSequence.LAST_INDEX; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }

    private static void writeToCSV(long[] sequence) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FibonacciSequence.FILE_NAME))) {
            writer.write("Index,Fibonacci");
            writer.newLine();
            for (int i = 0; i < sequence.length; i++) {
                writer.write(i + "," + sequence[i]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        long[] fibonacci = generateFibonacci();
        writeToCSV(fibonacci);

        System.out.println("Fibonacci sequence (F(0) to F(" + LAST_INDEX + ")) written to " + FILE_NAME);
        System.out.println("Total numbers written: " + fibonacci.length);
        System.out.println("F(" + LAST_INDEX + ") = " + fibonacci[LAST_INDEX]);
    }


}
