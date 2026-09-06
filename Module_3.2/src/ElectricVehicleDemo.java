interface Vehicle_Task3 {
    void start();
    void stop();
    String getInfo();
}


interface ElectricVehicle {
    void charge();
}


abstract class AbstractVehicle_Task3 implements Vehicle_Task3, ElectricVehicle {
    private String model;
    private int yearOfCreation;
    private int fuel;
    private String type;

    AbstractVehicle_Task3(String model, String type, int yearOfCreation, int fuel) {
        this.model = model;
        this.yearOfCreation = yearOfCreation;
        this.fuel = fuel;
        this.type = type;
    }

    String getModel() { return model; }
    String getType() { return type; }
    int getYearOfCreation() { return yearOfCreation; }
    int getFuel() { return fuel; }

    void setModel(String model) { this.model = model; }
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


class Car_Task3 extends AbstractVehicle_Task3 {
    Car_Task3(String model, int yearOfCreation, int fuel) {
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

    @Override
    public void charge() {
        System.out.println("Car cannot be charged (gasoline vehicle).");
    }
}


class Motorcycle_Task3 extends AbstractVehicle_Task3 {
    Motorcycle_Task3(String model, int yearOfCreation, int fuel) {
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

    @Override
    public void charge() {
        System.out.println("Motorcycle cannot be charged (gasoline vehicle).");
    }
}


class Bus_Task3 extends AbstractVehicle_Task3 {
    Bus_Task3(String model, int yearOfCreation, int fuel) {
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

    @Override
    public void charge() {
        System.out.println("Bus cannot be charged (diesel vehicle).");
    }
}


class ElectricCar extends AbstractVehicle_Task3 {
    ElectricCar(String model, int yearOfCreation, int fuel) {
        super(model, "Electric Car", yearOfCreation, fuel);
    }

    @Override
    public void start() {
        System.out.println("Electric Car is starting silently...");
    }

    @Override
    public void stop() {
        System.out.println("Electric Car is stopping...");
    }

    @Override
    public String getInfo() {
        return """
                Electric Car Information:
                Type: Electric Car
                Fuel: Electricity
                Color: White
                Charging Time: 20 hours (full charge)
                """;
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Car... Will take 20 hours to fully charge.");
    }
}


class ElectricMotorcycle extends AbstractVehicle_Task3 {
    ElectricMotorcycle(String model, int yearOfCreation, int fuel) {
        super(model, "Electric Motorcycle", yearOfCreation, fuel);
    }

    @Override
    public void start() {
        System.out.println("Electric Motorcycle is starting silently...");
    }

    @Override
    public void stop() {
        System.out.println("Electric Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return """
                Electric Motorcycle Information:
                Type: Electric Motorcycle
                Fuel: Electricity
                Color: Black
                Charging Time: 7 hours (full charge)
                """;
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Motorcycle... Will take 7 hours to fully charge.");
    }
}


public class ElectricVehicleDemo {
    public static void main(String[] args) {
        AbstractVehicle_Task3[] vehicles = {
                new Car_Task3("Chevrolette", 2026, 200),
                new Motorcycle_Task3("FastestBikeEver", 2018, 100),
                new Bus_Task3("School Bus", 2008, 50),
                new ElectricCar("Tesla", 2025, 0),
                new ElectricMotorcycle("X1 Pro", 2024, 0)
        };

        System.out.println("Vehicle Demonstration");

        for (AbstractVehicle_Task3 vehicle : vehicles) {
            System.out.println();
            vehicle.start();
            System.out.println();
            System.out.print(vehicle.getInfo());
            vehicle.displayInfo();
            System.out.println();
            vehicle.charge();
            System.out.println();
            vehicle.stop();
        }
    }
}