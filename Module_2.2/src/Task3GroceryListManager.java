import java.util.HashMap;

public class Task3GroceryListManager {

    // Sisäinen luokka, joka säilyttää tuotteen hinnan ja kategorian
    private static class ItemDetails {
        double cost;
        String category;

        ItemDetails(double cost, String category) {
            this.cost = cost;
            this.category = category;
        }
    }

    // HashMap (nimi, hinta + kategoria)
    private HashMap<String, ItemDetails> groceryList = new HashMap<>();

    // Lisää tuotteen ostoslistalle yhdessä hinnan ja kategorian kanssa
    public void addItem(String item, double cost, String category) {
        groceryList.put(item, new ItemDetails(cost, category));
    }

    // Poistaa tuotteen ostoslistalta, jos se löytyy
    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            System.out.println("\"" + item + "\" was removed from the list.");
        } else {
            System.out.println("\"" + item + "\" was not found in the list.");
        }
    }

    // Näyttää kaikki ostoslistan tuotteet hintoineen ja kategorioineen
    public void displayList() {
        System.out.println("Grocery List:");
        int index = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            System.out.printf("%d. %s - $%.2f (%s)%n", index, item, details.cost, details.category);
            index++;
        }
    }

    // Tarkistaa, onko annettu tuote ostoslistalla
    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    // Laskee ja palauttaa kaikkien tuotteiden yhteishinnan
    public double calculateTotalCost() {
        double total = 0.0;
        for (ItemDetails details : groceryList.values()) {
            total += details.cost;
        }
        return total;
    }

    // Näyttää kaikki tietyn kategorian tuotteet
    public void displayByCategory(String category) {
        System.out.println("Category: " + category);
        boolean found = false;
        int index = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            // Verrataan kategoriaa kirjainkoosta välittämättä
            if (details.category.equalsIgnoreCase(category)) {
                System.out.printf("%d. %s - $%.2f%n", index, item, details.cost);
                index++;
                found = true;
            }
        }
        // Ilmoitetaan, jos kategoriasta ei löytynyt yhtään tuotetta
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    public static void main(String[] args) {
        Task3GroceryListManager manager = new Task3GroceryListManager();

        // Testaus hintoineen ja kategorioineen
        manager.addItem("Apples", 3.50, "Fruits");
        manager.addItem("Milk", 2.75, "Dairy");
        manager.addItem("Bread", 4.00, "Bakery");
        manager.addItem("Bananas", 1.20, "Fruits");
        manager.addItem("Cheese", 5.30, "Dairy");

        manager.displayList();

        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        System.out.printf("%nTotal Cost: $%.2f%n", manager.calculateTotalCost());

        // Näytetään tuotteet kategorian mukaan
        System.out.println();
        manager.displayByCategory("Fruits");

        System.out.println();
        manager.displayByCategory("Dairy");

        System.out.println();
        manager.displayByCategory("Bakery");

        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        // Näytetään päivitetty lista ja kokonaishinta
        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
        System.out.printf("%nUpdated Total Cost: $%.2f%n", manager.calculateTotalCost());
    }
}