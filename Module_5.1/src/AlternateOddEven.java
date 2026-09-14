public class AlternateOddEven {
    private int count = 1;
    private final int MAX_RANGE;

    public AlternateOddEven(int maxRange) {
        this.MAX_RANGE = maxRange;
    }

    public void printOdd() {
        synchronized (this) {
            while (count <= MAX_RANGE) {
                if (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Odd Thread: " + count);
                    count++;
                    notifyAll();
                }
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (count <= MAX_RANGE) {
                if (count % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Even Thread: " + count);
                    count++;
                    notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        int range = 20;
        AlternateOddEven printer = new AlternateOddEven(range);

        Thread oddThread = new Thread(printer::printOdd, "OddThread");
        Thread evenThread = new Thread(printer::printEven, "EvenThread");

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Printing complete.");
    }
}