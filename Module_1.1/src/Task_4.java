public class Task_4 {
    private String name;

    public Task_4(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create two instances of the Cat class with different names
        Task_4 whiskers = new Task_4("Whiskers");
        Task_4 rex = new Task_4("Rex");

        // Call the meow method on each cat instance in the required order
        whiskers.meow();
        whiskers.meow();
        rex.meow();
        whiskers.meow();
    }
}