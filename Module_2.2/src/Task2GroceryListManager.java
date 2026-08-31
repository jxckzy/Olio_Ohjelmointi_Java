import java.util.HashMap;

public class Task2GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    // Hinta lisätty
    public void addItem(String item, double cost) {
        groceryList.put(item, cost);
    }

    // Jos ei ole listassa, sitä ei löydy
    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            System.out.println("\"" + item + "\" was removed from the list.");
        } else {
            System.out.println("\"" + item + "\" was not found in the list.");
        }
    }

    // Näyttää kaikki tuotteet, jotka ovat listassa hintoineen
    public void displayList() {
        System.out.println("Grocery List:");
        int index = 1;
        for (String item : groceryList.keySet()) {
            System.out.printf("%d. %s - $%.2f%n", index, item, groceryList.get(item));
            index++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    // Laskee kokonaishinta kaikista olevista tuotteista
    public double calculateTotalCost() {
        double total = 0.0;
        for (double cost : groceryList.values()) {
            total += cost;
        }
        return total;
    }

    public static void main(String[] args) {
        Task2GroceryListManager manager = new Task2GroceryListManager();

        // Tuotteiden testaus hintoineen (varmuuden vuoksi)
        manager.addItem("Apples", 3.50);
        manager.addItem("Milk", 2.75);
        manager.addItem("Bread", 4.00);

        manager.displayList();

        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        System.out.printf("%nTotal Cost: $%.2f%n", manager.calculateTotalCost());

        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        // Lasketaan kokonaishinta ja näytetään myös ostoslista
        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
        System.out.printf("%nUpdated Total Cost: $%.2f%n", manager.calculateTotalCost());
    }
}