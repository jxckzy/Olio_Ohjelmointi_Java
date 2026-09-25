import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VirtualPet extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pet myPet = new Pet(400, 300, 4.0);
        Controller myController = new Controller(myPet);
        View myView = new View(myController, myPet);

        Scene scene = new Scene(myView, 800, 600);

        primaryStage.setTitle("Virtual Pet (cat)");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}