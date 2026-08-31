/* Tehtävässä 4 tehdään TDD (test driven development), jossa
    löydetään mahdolliset rajapinnan ongelmat ennen
    toteuttamista
 */
public class Car4Task {
    private double speed;
    private double gasolineLevel;
    private String typeName;

    // TEHTÄVÄ 4 -- VAKAUSOHJAIN (asetukset)
    private static final double MIN_CRUISE_SPEED = 30;
    private static final double MAX_CRUISE_SPEED = 120;
    private double targetSpeed;
    private boolean cruiseControlOn;

    public Car4Task(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
    }

    // Tehtävästä 2...
    public Car4Task(String typeName, double gasolineLevel, double speed) {
        this.speed = speed; this.gasolineLevel = gasolineLevel;
        this.typeName = typeName;
    }

    public void accelerate() {
        if (gasolineLevel <= 0) {
            speed = 0;
            cruiseControlOn = false;   // vakausohjain jos bensaa ei ole
            return;
        }
        if (cruiseControlOn) {
            driveTowardTarget();
        } else {
            speed += 10;
        }
    }

    void decelerate(int amount) {
        if (gasolineLevel <= 0) {
            speed = 0;
            cruiseControlOn = false;
            return;
        }
        if (cruiseControlOn) {
            driveTowardTarget();
        } else if (amount > 0) {
            speed = Math.max(0, speed - amount);
        }
    }

    // Siirtää nopeutta yhden askeleen kohti tavoitenopeutta (käytössä kun vakionopeudensäädin on päällä)
    private void driveTowardTarget() {
        if (speed < targetSpeed) {
            speed = Math.min(targetSpeed, speed + 10);
        } else if (speed > targetSpeed) {
            speed = Math.max(targetSpeed, speed - 10);
        }
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

    // Vakausohjain
    public void setTargetSpeed(double targetSpeed) {
        if (targetSpeed >= MIN_CRUISE_SPEED && targetSpeed <= MAX_CRUISE_SPEED) {
            this.targetSpeed = targetSpeed;
        }
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    // Palauttaa true, jos vakionopeudensäädin saatiin onnistuneesti päälle,
    // false jos sitä ei voitu kytkeä päälle
    public boolean turnOn() {
        if (gasolineLevel <= 0
                || targetSpeed < MIN_CRUISE_SPEED
                || targetSpeed > MAX_CRUISE_SPEED) {
            cruiseControlOn = false;
            return false;
        }
        cruiseControlOn = true;
        return true;
    }

    public void turnOff() {
        cruiseControlOn = false;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }
}


class CarDriver4Task {
    public static void main(String[] args) {
        Car4Task myCar = new Car4Task("Toyota Corolla");
        myCar.fillTank();

        // Asetetaan tavoitenopeus ja yritetään kytkeä vakionopeudensäädin päälle
        myCar.setTargetSpeed(80);
        boolean started = myCar.turnOn();
        System.out.println("Cruise control on: " + started);

        // Ajetaan hetki vakionopeudensäätimen ollessa päällä
        for (int i = 0; i < 5; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        // Tarkistetaan nykyinen tavoitenopeus
        System.out.println("Target speed: " + myCar.getTargetSpeed());

        myCar.turnOff();
        System.out.println("Cruise control turned off");

        // Yritetään kytkeä vakionopeudensäädin päälle ilman bensaa — pitäisi epäonnistua
        Car4Task emptyCar = new Car4Task("Empty Car");
        emptyCar.setTargetSpeed(50);
        boolean ok = emptyCar.turnOn();
        System.out.println("Cruise control on for empty car: " + ok);
    }
}