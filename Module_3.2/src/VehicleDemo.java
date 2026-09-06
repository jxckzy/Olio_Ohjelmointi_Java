interface Vehicle {
    void start();
    void stop();
    String getInfo();
}


class Car implements Vehicle {
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


class Motorcycle implements Vehicle {
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


class Bus implements Vehicle {
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

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(),
                new Motorcycle(),
                new Bus()
        };

        System.out.println("Vehicle Demonstration");
        System.out.println();

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo());
        }
    }
}
