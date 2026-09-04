// Car-luokka on sama kuin ensimmäisessä tehtävässä (sportscar.java)

public class Bus extends Car {
    private int passengers;
    private final int maxPassengers;

    public Bus(String typeName, double gasolineLevel, double speed, int maxPassengers) {
        super(typeName, gasolineLevel, speed);
        this.maxPassengers = maxPassengers;
        this.passengers = 0;
    }

    public boolean passengerEnter() {
        if (passengers < maxPassengers) {
            passengers++;
            System.out.println("Passenger entered!");
            return true;
        }

        return false;
    }

    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
            System.out.println("Passenger left!");
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public static void main(String[] args) {
        Bus bus = new Bus("City Bus", 100, 0, 6);

        //Testaillaan matkailijoiden pääsemistä
        bus.passengerEnter();
        bus.passengerEnter();
        bus.passengerEnter();

        System.out.println("Passengers: " + bus.getPassengers());

        // Testaillaan kun matkailija poistuu
        bus.passengerExit();

        System.out.println("Passengers: " + bus.getPassengers());

        // Matkailijoiden enimmäismäärä
        System.out.println("\nNow we are testing max amount of passengers:\n");
        for (int i = 0; i < 8; i++) {
            if (bus.passengerEnter())
                System.out.println("Now there is " + bus.getPassengers() + " people on the bus.");
            else
                System.out.println("Bus is full!");
        }
    }
}