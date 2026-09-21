import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CurrencyModel model = new CurrencyModel();
        CurrencyView view = new CurrencyView();
        new CurrencyController(model, view);
        Scene scene = new Scene(view.getRoot(), 420, 480);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}