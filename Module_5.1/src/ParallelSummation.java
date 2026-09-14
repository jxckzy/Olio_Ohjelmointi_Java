import java.util.Random;

public class ParallelSummation {
    public static void main(String[] args) {
        int arraySize = 100_000;
        int[] numbers = new int[arraySize];
        Random random = new Random();

        long sequentialSum = 0;
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = random.nextInt(100);
            sequentialSum += numbers[i];
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processor cores: " + cores);

        Thread[] threads = new Thread[cores];
        long[] partialSums = new long[cores];

        int chunkSize = arraySize / cores;

        for (int i = 0; i < cores; i++) {
            final int threadIndex = i;
            final int start = i * chunkSize;
            final int end = (i == cores - 1) ? arraySize : start + chunkSize;

            threads[i] = new Thread(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += numbers[j];
                }
                partialSums[threadIndex] = localSum;
            });

            threads[i].start();
        }

        long parallelSum = 0;
        for (int i = 0; i < cores; i++) {
            try {
                threads[i].join();
                parallelSum += partialSums[i];
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted.");
            }
        }

        System.out.println("Total sum calculated sequentially: " + sequentialSum);
        System.out.println("Total sum calculated in parallel:  " + parallelSum);
    }
}