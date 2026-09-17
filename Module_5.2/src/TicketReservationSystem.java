class Theater {
    private int availableSeats;

    public Theater(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public synchronized void reserveTickets(int customerId, int requestedSeats) {
        if (requestedSeats <= availableSeats) {
            availableSeats -= requestedSeats;
            System.out.println("Customer " + customerId + " reserved " + requestedSeats + " tickets.");
        } else {
            System.out.println("Customer " + customerId + " couldn't reserve " + requestedSeats + " tickets.");
        }
    }
}

class Customer extends Thread {
    private Theater theater;
    private int customerId;
    private int requestedSeats;

    public Customer(Theater theater, int customerId, int requestedSeats) {
        this.theater = theater;
        this.customerId = customerId;
        this.requestedSeats = requestedSeats;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        theater.reserveTickets(customerId, requestedSeats);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        Theater theater = new Theater(10);

        int[] ticketRequests = {2, 1, 3, 1, 2, 2, 1, 1, 3, 3, 2, 4, 1, 4, 3};

        Thread[] customers = new Thread[15];
        for (int i = 0; i < 15; i++) {
            customers[i] = new Customer(theater, i + 1, ticketRequests[i]);
            customers[i].start();
        }

        for (int i = 0; i < 15; i++) {
            try {
                customers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}