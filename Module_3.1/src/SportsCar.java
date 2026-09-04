class Car {
    protected double speed;
    protected double gasolineLevel;
    protected String typeName;

    protected static final double MIN_CRUISE_SPEED = 30;
    protected static final double MAX_CRUISE_SPEED = 120;
    protected double targetSpeed;
    protected boolean cruiseControlOn;

    public Car(String typeName, double gasolineLevel, double speed) {
        this.speed = speed; this.gasolineLevel = gasolineLevel;
        this.typeName = typeName;
    }

    public void accelerate() {
        if (gasolineLevel <= 0) {
            speed = 0;
            cruiseControlOn = false;
            return;
        }
        if (cruiseControlOn) {
            driveTowardTarget();
        } else {
            speed += 10;
        }
    }

    public void decelerate(int amount) {
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

    public void driveTowardTarget() {
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

    public void setTargetSpeed(double targetSpeed) {
        if (targetSpeed >= MIN_CRUISE_SPEED && targetSpeed <= MAX_CRUISE_SPEED) {
            this.targetSpeed = targetSpeed;
        }
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

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


public class SportsCar extends Car {
    public SportsCar(String typeName, double gasolineLevel, double speed) {
        super(typeName, gasolineLevel, speed);
    }

    @Override
    public void accelerate() {
        if (gasolineLevel <= 0) {
            speed = 0;
            cruiseControlOn = false;
            return;
        }

        if (cruiseControlOn) {
            driveTowardTarget();
        } else {
            speed += 20;
            gasolineLevel -= 5;
        }
    }

    @Override
    public void decelerate(int amount) {
        if (gasolineLevel <= 0) {
            speed = 0;
            cruiseControlOn = false;
            return;
        }

        if (cruiseControlOn) {
            driveTowardTarget();
        } else if (amount > 0) {
            speed = Math.max(0, speed - amount * 2);
        }
    }

    public static void main(String[] args) {
        SportsCar sportsCar = new SportsCar("Porsche", 200, 30);
        System.out.println("Starting speed: " + sportsCar.getSpeed());
        System.out.println("Gasoline: " + sportsCar.getGasolineLevel());

        System.out.println("\nAccelerating:");
        for (int i = 0; i < 5; i++) {
            sportsCar.accelerate();
            System.out.println("Speed: " + sportsCar.getSpeed() + " km/h, Gasoline: " + sportsCar.getGasolineLevel());
        }

        System.out.println("\nDecelerating:");
        for (int i = 0; i < 5; i++) {
            sportsCar.decelerate(20);
            System.out.println("Speed: " + sportsCar.getSpeed() + " km/h, Gasoline: " + sportsCar.getGasolineLevel());
            if (sportsCar.getSpeed() == 0) {
                System.out.println("Porsche has stopped!");
                break;
            }
        }
    }
}
