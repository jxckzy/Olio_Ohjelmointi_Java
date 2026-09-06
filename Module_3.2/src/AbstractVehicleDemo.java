interface Vehicle_Task2 {
    void start();
    void stop();
    String getInfo();
}


abstract class AbstractVehicle implements Vehicle_Task2 {
    private String model;
    private int yearOfCreation;
    private int fuel;
    private String type;

    AbstractVehicle(String model, String type, int yearOfCreation, int fuel) {
        this.model = model; this.yearOfCreation = yearOfCreation;
        this.fuel = fuel; this.type = type;
    }

    String getModel() { return model; }
    String getType() { return type; }
    int getYearOfCreation() { return yearOfCreation; }
    int getFuel() { return fuel; }

    void setModel(String  model) { this.model = model; }
    void setType(String type) { this.type = type; }
    void setYearOfCreation(int yearOfCreation) { this.yearOfCreation = yearOfCreation; }
    void setFuel(int fuel) { this.fuel = fuel; }

    void refuel(int amount) {
        this.fuel += amount;
        System.out.println("Refueled! Your fuel is now: " + this.fuel);
    }

    void displayInfo() {
        String info = """
                Model: %s,
                Type: %s,
                Year: %d,
                Fuel: %d
                """;
        System.out.printf(info, model, type, yearOfCreation, fuel);
    }
}


class Car_Task2 extends AbstractVehicle {
    Car_Task2(String model, int yearOfCreation, int fuel) {
        super(model, "Car", yearOfCreation, fuel);
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return """
                Car Information:
                Type: Car
                Fuel: Petrol
                Color: Red
                """;
    }
}


class Motorcycle_Task2 extends AbstractVehicle {
    Motorcycle_Task2(String model, int yearOfCreation, int fuel) {
        super(model, "Motorcycle", yearOfCreation, fuel);
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return """
                Motorcycle Information:
                Type: Motorcycle
                Fuel: Gasoline
                Color: Black
                """;
    }
}


class Bus_Task2 extends AbstractVehicle {
    Bus_Task2(String model, int yearOfCreation, int fuel) {
        super(model, "Bus", yearOfCreation, fuel);
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return """
                Bus Information:
                Type: Bus
                Fuel: Diesel
                Capacity: 40 passengers
                """;
    }
}

public class AbstractVehicleDemo {
    public static void main(String[] args) {
        AbstractVehicle[] vehicles = {
                new Car_Task2("Chevrolette", 2026, 200),
                new Motorcycle_Task2("FastestBikeEver", 2018, 100),
                new Bus_Task2("School Bus", 2008, 50)
        };

        System.out.println("Vehicle Demonstration");
        System.out.println();

        for (AbstractVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo());
        }

        System.out.println("Now lets check new Abstract Vehicle");
        System.out.println();

        for (AbstractVehicle vehicle : vehicles) {
            System.out.println();
            vehicle.displayInfo();
            vehicle.refuel(50);
        }
    }
}
