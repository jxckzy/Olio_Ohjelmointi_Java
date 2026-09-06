interface Vehicle_Task4 {
    void start();
    void stop();
    String getInfo();
    double calculateFuelEfficiency();
}


interface ElectricVehicle_Task4 {
    void charge();
}


abstract class AbstractVehicle_Task4 implements Vehicle_Task4, ElectricVehicle_Task4 {
    private String model;
    private int yearOfCreation;
    private int fuel;
    private String type;
    private double fuelEfficiency;

    AbstractVehicle_Task4(String model, String type, int yearOfCreation, int fuel, double fuelEfficiency) {
        this.model = model;
        this.yearOfCreation = yearOfCreation;
        this.fuel = fuel;
        this.type = type;
        this.fuelEfficiency = fuelEfficiency;
    }

    String getModel() { return model; }
    String getType() { return type; }
    int getYearOfCreation() { return yearOfCreation; }
    int getFuel() { return fuel; }
    double getFuelEfficiency() { return fuelEfficiency; }

    void setModel(String model) { this.model = model; }
    void setType(String type) { this.type = type; }
    void setYearOfCreation(int yearOfCreation) { this.yearOfCreation = yearOfCreation; }
    void setFuel(int fuel) { this.fuel = fuel; }
    void setFuelEfficiency(double fuelEfficiency) { this.fuelEfficiency = fuelEfficiency; }

    void refuel(int amount) {
        this.fuel += amount;
        System.out.println("Refueled! Your fuel is now: " + this.fuel);
    }

    void displayInfo() {
        String info = """
                Model: %s,
                Type: %s,
                Year: %d,
                Fuel: %d,
                Fuel Efficiency: %.2f
                """;
        System.out.printf(info, model, type, yearOfCreation, fuel, fuelEfficiency);
    }
}


class Car_Task4 extends AbstractVehicle_Task4 {
    Car_Task4(String model, int yearOfCreation, int fuel) {
        super(model, "Car", yearOfCreation, fuel, 10.5);
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
    public double calculateFuelEfficiency() {
        System.out.println("Car fuel efficiency: " + getFuelEfficiency() + " km/liter");
        return getFuelEfficiency();
    }

    @Override
    public void charge() {
        System.out.println("Car cannot be charged (gasoline vehicle).");
    }
}


class Motorcycle_Task4 extends AbstractVehicle_Task4 {
    Motorcycle_Task4(String model, int yearOfCreation, int fuel) {
        super(model, "Motorcycle", yearOfCreation, fuel, 25.0);
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
    public double calculateFuelEfficiency() {
        System.out.println("Motorcycle fuel efficiency: " + getFuelEfficiency() + " km/liter");
        return getFuelEfficiency();
    }

    @Override
    public void charge() {
        System.out.println("Motorcycle cannot be charged (gasoline vehicle).");
    }
}


class Bus_Task4 extends AbstractVehicle_Task4 {
    Bus_Task4(String model, int yearOfCreation, int fuel) {
        super(model, "Bus", yearOfCreation, fuel, 5.5);
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
    public double calculateFuelEfficiency() {
        System.out.println("Bus fuel efficiency: " + getFuelEfficiency() + " km/liter");
        return getFuelEfficiency();
    }

    @Override
    public void charge() {
        System.out.println("Bus cannot be charged (diesel vehicle).");
    }
}


class ElectricCar_Task4 extends AbstractVehicle_Task4 {
    ElectricCar_Task4(String model, int yearOfCreation, int fuel) {
        super(model, "Electric Car", yearOfCreation, fuel, 0.18);
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
    public double calculateFuelEfficiency() {
        System.out.println("Electric Car energy efficiency: " + getFuelEfficiency() + " kWh/km");
        return getFuelEfficiency();
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Car... Will take 20 hours to fully charge.");
    }
}


class ElectricMotorcycle_Task4 extends AbstractVehicle_Task4 {
    ElectricMotorcycle_Task4(String model, int yearOfCreation, int fuel) {
        super(model, "Electric Motorcycle", yearOfCreation, fuel, 0.10);
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
    public double calculateFuelEfficiency() {
        System.out.println("Electric Motorcycle energy efficiency: " + getFuelEfficiency() + " kWh/km");
        return getFuelEfficiency();
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Motorcycle... Will take 7 hours to fully charge.");
    }
}


public class ElectricVehicleDemoTask4 {
    public static void main(String[] args) {
        AbstractVehicle_Task4[] vehicles = {
                new Car_Task4("Chevrolette", 2026, 200),
                new Motorcycle_Task4("FastestBikeEver", 2018, 100),
                new Bus_Task4("School Bus", 2008, 50),
                new ElectricCar_Task4("Tesla", 2025, 0),
                new ElectricMotorcycle_Task4("X1 Pro", 2024, 0)
        };

        System.out.println("Vehicle Demonstration");
        System.out.println("=".repeat(50));

        for (AbstractVehicle_Task4 vehicle : vehicles) {
            System.out.println();
            vehicle.start();
            System.out.println();
            System.out.print(vehicle.getInfo());
            vehicle.displayInfo();
            System.out.println();
            vehicle.charge();
            System.out.println();
            vehicle.calculateFuelEfficiency();
            System.out.println();
            vehicle.stop();
            System.out.println("-".repeat(50));
        }
    }
}