import java.util.ArrayList;
import java.util.List;

class ThreadSafeList<T> {
    private final List<T> list;

    public ThreadSafeList() {
        this.list = new ArrayList<>();
    }

    public synchronized void add(T element) {
        list.add(element);
    }

    public synchronized boolean remove(T element) {
        return list.remove(element);
    }

    public synchronized int size() {
        return list.size();
    }
}

public class ThreadSafeTest {
    public static void main(String[] args) {
        ThreadSafeList<String> safeList = new ThreadSafeList<>();

        int numThreads = 10;
        int operationsPerThread = 1000;
        Thread[] threads = new Thread[numThreads];

        System.out.println("Starting thread-safety test...");

        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < operationsPerThread; j++) {
                    safeList.add("Thread-" + threadId + "-Item-" + j);
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int expectedSize = numThreads * operationsPerThread;
        int actualSize = safeList.size();

        System.out.println("Expected Size: " + expectedSize);
        System.out.println("Actual Size:   " + actualSize);

        if (expectedSize == actualSize) {
            System.out.println("SUCCESS: Thread-safety confirmed. No data was lost.");
        } else {
            System.out.println("FAILURE: Race condition detected. Elements were lost.");
        }

        System.out.println("\nTesting removal...");
        safeList.remove("Thread-0-Item-0");
        System.out.println("Size after removing 1 element: " + safeList.size());
    }
}