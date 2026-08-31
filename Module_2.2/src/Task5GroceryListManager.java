import java.util.HashMap;

public class Task5GroceryListManager {

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

    // NYT SE LASKEE KOKONAISHINTA KERTOMALLA TUOTTEEN MÄÄRÄLLÄ (tehtävänanto 5)
    public double calculateTotalCost() {
        double total = 0.0;
        for (ItemDetails details : groceryList.values()) {
            total += details.cost * details.quantity;
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
                System.out.printf("%d. %s - $%.2f - Qty: %d%n", index, item, details.cost, details.quantity);
                index++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            groceryList.get(item).quantity = newQuantity;
            System.out.println("Quantity of \"" + item + "\" updated to " + newQuantity + ".");
        } else {
            System.out.println("\"" + item + "\" was not found in the list.");
        }
    }

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
        if (!found) {
            System.out.println("No available items.");
        }
    }

    // Testaa kokonaishinnan laskennan eri hinnoilla ja määrillä
    public void testTotalCostCalculation() {
        System.out.println("Total Price Test");

        // Luodaan erillinen testiolio
        Task5GroceryListManager testManager = new Task5GroceryListManager();

        // Lisätään tuotteita eri hinnoilla ja määrillä
        testManager.addItem("Eggs", 0.50, "Dairy", 12);   // 0.50 * 12 = 6.00
        testManager.addItem("Rice", 1.80, "Grains", 3);   // 1.80 * 3 = 5.40
        testManager.addItem("Butter", 3.20, "Dairy", 2);  // 3.20 * 2 = 6.40

        testManager.displayList();

        double expectedTotal = (0.50 * 12) + (1.80 * 3) + (3.20 * 2);
        double actualTotal = testManager.calculateTotalCost();

        System.out.printf("Expected Total Cost: $%.2f%n", expectedTotal);
        System.out.printf("Actual Total Cost: $%.2f%n", actualTotal);
        System.out.println("Test Result: " + (Math.abs(expectedTotal - actualTotal) < 0.001 ? "PASSED" : "FAILED"));
        System.out.println();
    }

    // Testaa tuotteiden kategorisoinnin lisäämällä tuotteita eri kategorioihin
    public void testCategorization() {
        System.out.println("Categorization Test");

        Task5GroceryListManager testManager = new Task5GroceryListManager();

        // Lisätään tuotteita useisiin eri kategorioihin
        testManager.addItem("Apples", 3.50, "Fruits", 5);
        testManager.addItem("Bananas", 1.20, "Fruits", 6);
        testManager.addItem("Milk", 2.75, "Dairy", 2);
        testManager.addItem("Cheese", 5.30, "Dairy", 1);
        testManager.addItem("Bread", 4.00, "Bakery", 3);

        // Näytetään yksi kategoria kerrallaan varmistaakseen suodatuksen toimivuuden
        testManager.displayByCategory("Fruits");
        System.out.println();
        testManager.displayByCategory("Dairy");
        System.out.println();
        testManager.displayByCategory("Bakery");
        System.out.println();

        // Testataan myös kategoriaa, josta ei löydy tuotteita
        testManager.displayByCategory("Frozen");
        System.out.println();
    }

    // Testaa määrän seurannan lisäämällä tuotteita eri määrillä ja päivittämällä niitä
    public void testQuantityTracking() {
        System.out.println("Quantity Tracking Test");

        Task5GroceryListManager testManager = new Task5GroceryListManager();

        // Lisätään tuotteita, joilla on eri määrät, mukaan lukien nolla
        testManager.addItem("Oranges", 2.00, "Fruits", 4);
        testManager.addItem("Yogurt", 1.50, "Dairy", 0);
        testManager.addItem("Pasta", 1.10, "Grains", 8);

        System.out.println("Before update:");
        testManager.displayAvailableItems();

        // Päivitetään yhden tuotteen määrä nollasta positiiviseksi
        System.out.println("\nUpdating \"Yogurt\" quantity to 5...");
        testManager.updateQuantity("Yogurt", 5);

        // Päivitetään toisen tuotteen määrä positiivisesta nollaan
        System.out.println("Updating \"Oranges\" quantity to 0...");
        testManager.updateQuantity("Oranges", 0);

        System.out.println("\nAfter update:");
        testManager.displayAvailableItems();

        // Yritetään päivittää tuotetta, jota ei ole listalla
        System.out.println("\nAttempting to update a non-existent item...");
        testManager.updateQuantity("Cereal", 10);
        System.out.println();
    }

    public static void main(String[] args) {
        // Koko "ostoksien simulaattorin" testaus kaikine ominaisuuksineen
        Task5GroceryListManager manager = new Task5GroceryListManager();

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

        System.out.println();
        manager.displayAvailableItems();

        System.out.println("\nUpdating quantity of \"Bread\"...");
        manager.updateQuantity("Bread", 3);

        System.out.println("\nAvailable Items after update:");
        manager.displayAvailableItems();

        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
        System.out.printf("%nUpdated Total Cost: $%.2f%n", manager.calculateTotalCost());

        // Kaikki muu testaus on tässä kohdassa
        System.out.println("\n\nNew Features Tests\n");
        manager.testTotalCostCalculation();
        manager.testCategorization();
        manager.testQuantityTracking();
    }
}