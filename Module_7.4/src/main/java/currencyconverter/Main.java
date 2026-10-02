package currencyconverter;

import currencyconverter.controller.CurrencyController;
import currencyconverter.dao.CurrencyDao;
import currencyconverter.view.CurrencyView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CurrencyDao currencyDao = new CurrencyDao();
        CurrencyView view = new CurrencyView();
        new CurrencyController(currencyDao, view);

        Scene scene = new Scene(view.getRoot(), 420, 520);
        primaryStage.setTitle("Currency Converter (JPA Transactions)");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}