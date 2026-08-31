public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;

    public Car(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
    }

    // TEHTÄVÄ 2 – Säädettävä auto: nopeus ja polttoaine
    public Car(String typeName, double gasolineLevel, double speed) {
        this.speed = speed; this.gasolineLevel = gasolineLevel;
        this.typeName = typeName;
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        gasolineLevel = 100;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
}


class CarDriver {
    public static void main(String[] args) {
        Car myCar1;
        Car myCar2;

        myCar1 = new Car("Toyota Corolla"); // auto moduulin esimerkistä
        myCar2 = new Car("Audi Q6", 100, 20); // auto tehtävän mukaan, säädettävä auto
        myCar1.fillTank();

        // Testataan Car 1 moduulin esimerkistä
        for (int i = 0; i < 6; i++) {
            myCar1.accelerate();
            System.out.println(myCar1.getTypeName() + ": speed is " + myCar1.getSpeed() + " km/h");
        }
        while (myCar1.getSpeed() > 0) {
            myCar1.decelerate(15);
            System.out.println(myCar1.getTypeName() + ": speed is " + myCar1.getSpeed() + " km/h");
        }

        // Testataan Car 2 tehtävänannosta 2
        for (int i = 0; i < 6; i++) {
            myCar2.accelerate();
            System.out.println(myCar2.getTypeName() + ": speed is " + myCar2.getSpeed() + " km/h");
        }
        while (myCar2.getSpeed() > 0) {
            myCar2.decelerate(15);
            System.out.println(myCar2.getTypeName() + ": speed is " + myCar2.getSpeed() + " km/h");
        }
    }
}