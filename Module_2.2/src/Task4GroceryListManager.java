import java.util.HashMap;

public class Task4GroceryListManager {

    // Luokka hintoineen, kategorioineen ja määrineen
    private static class ItemDetails {
        double cost;
        String category;
        int quantity;

        ItemDetails(double cost, String category, int quantity) {
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    // Lisäsin määrä HashMapiin kaiken muun lisäksi
    private HashMap<String, ItemDetails> groceryList = new HashMap<>();

    public void addItem(String item, double cost, String category, int quantity) {
        groceryList.put(item, new ItemDetails(cost, category, quantity));
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            System.out.println("\"" + item + "\" was removed from the list.");
        } else {
            System.out.println("\"" + item + "\" was not found in the list.");
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        int index = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            System.out.printf("%d. %s - $%.2f (%s) - Qty: %d%n", index, item, details.cost, details.category, details.quantity);
            index++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (ItemDetails details : groceryList.values()) {
            total += details.cost;
        }
        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("Category: " + category);
        boolean found = false;
        int index = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            if (details.category.equalsIgnoreCase(category)) {
                System.out.printf("%d. %s - $%.2f%n", index, item, details.cost);
                index++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    // Päivittää tietyn tuotteen määrän
    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            groceryList.get(item).quantity = newQuantity;
            System.out.println("Quantity of \"" + item + "\" updated to " + newQuantity + ".");
        } else {
            System.out.println("\"" + item + "\" was not found in the list.");
        }
    }

    // Näyttää tuotteet, joiden määrä on suurempi kuin nolla
    public void displayAvailableItems() {
        System.out.println("Available Items:");
        boolean found = false;
        int index = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            // Näytetään vain tuotteet, joiden määrä on positiivinen
            if (details.quantity > 0) {
                System.out.printf("%d. %s - Qty: %d%n", index, item, details.quantity);
                index++;
                found = true;
            }
        }
        // Ilmoitetaan, jos yhtään saatavilla olevaa tuotetta ei löytynyt
        if (!found) {
            System.out.println("No available items.");
        }
    }

    public static void main(String[] args) {
        Task4GroceryListManager manager = new Task4GroceryListManager();

        // Testaus hintoineen, kategorioineen ja määrineen
        manager.addItem("Apples", 3.50, "Fruits", 5);
        manager.addItem("Milk", 2.75, "Dairy", 2);
        manager.addItem("Bread", 4.00, "Bakery", 0);
        manager.addItem("Bananas", 1.20, "Fruits", 6);
        manager.addItem("Cheese", 5.30, "Dairy", 0);

        manager.displayList();

        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        System.out.printf("%nTotal Cost: $%.2f%n", manager.calculateTotalCost());

        System.out.println();
        manager.displayByCategory("Fruits");

        // Näytetään saatavilla olevat tuotteet (määrä > 0)
        System.out.println();
        manager.displayAvailableItems();

        // Päivitetään leivän määrä
        System.out.println("\nUpdating quantity of \"Bread\"...");
        manager.updateQuantity("Bread", 3);

        // Näytetään saatavilla olevat tuotteet uudelleen päivityksen jälkeen
        System.out.println("\nAvailable Items after update:");
        manager.displayAvailableItems();

        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
        System.out.printf("%nUpdated Total Cost: $%.2f%n", manager.calculateTotalCost());
    }
}