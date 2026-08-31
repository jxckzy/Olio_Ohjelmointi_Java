import java.util.ArrayList;

public class Task1GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    // Lisää tuotteen ostoslistalle
    public void addItem(String item) {
        groceryList.add(item);
    }

    // Poistaa tuotteen ostoslistalta
    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
            System.out.println("\"" + item + "\" was removed from the list.");
        } else {
            System.out.println("\"" + item + "\" was not found in the list.");
        }
    }

    // Näyttää kaikki ostoslistan tuotteet
    public void displayList() {
        System.out.println("Grocery List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    // Tarkistaa löytyykö tuote ostoslistalta
    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        Task1GroceryListManager manager = new Task1GroceryListManager();

        // Lisätään muutama tuote ostoslistalle
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        // Näytetään ostoslista
        manager.displayList();

        // Tarkistetaan, löytyykö tietty tuote listalta
        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        // Poistetaan tuote listalta
        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        // Näytetään päivitetty ostoslista
        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
    }
}