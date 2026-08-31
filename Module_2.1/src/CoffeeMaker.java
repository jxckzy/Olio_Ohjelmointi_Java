public class CoffeeMaker {
    public static final String NORMAL = "normal";
    public static final String ESPRESSO = "espresso";

    private boolean isOn;
    private String coffeeType;
    private int coffeeAmount;

    public CoffeeMaker() {
        isOn = false;
        coffeeType = NORMAL;
        coffeeAmount = 10;
    }

    public void pressOnOff() {
        isOn = !isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setCoffeeType(String coffeeType) {
        if (isOn) {
            this.coffeeType = coffeeType;
        }
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        if (isOn && coffeeAmount >= 10 && coffeeAmount <= 80) {
            this.coffeeAmount = coffeeAmount;
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}


class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker();

        myCoffeeMaker.pressOnOff();
        System.out.println("Coffee maker is on");

        myCoffeeMaker.setCoffeeType(CoffeeMaker.ESPRESSO);
        System.out.println("Coffee type is " + myCoffeeMaker.getCoffeeType());

        myCoffeeMaker.setCoffeeAmount(50); // tässä voi muokata kahvia
        System.out.println("Coffee amount is " + myCoffeeMaker.getCoffeeAmount() + " ml");

        myCoffeeMaker.pressOnOff();
        System.out.println("Coffee maker is off");
    }
}