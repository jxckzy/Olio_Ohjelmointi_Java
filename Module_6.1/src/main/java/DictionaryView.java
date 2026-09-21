import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    @Override
    public void start(Stage window) {
        Dictionary dictionary = new Dictionary();
        DictionaryController controller = new DictionaryController(dictionary);

        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");

        Button searchButton = new Button("Search");

        Label meaningLabel = new Label("Meaning will appear here.");
        meaningLabel.setWrapText(true);
        meaningLabel.setPrefWidth(280);
        meaningLabel.setStyle("-fx-text-fill: #333333; -fx-font-size: 14px;");

        searchButton.setOnAction(event -> {
            String wordToSearch = wordInput.getText();

            String result = controller.search(wordToSearch);
            meaningLabel.setText(result);
        });

        FlowPane layout = new FlowPane();
        layout.setHgap(10);
        layout.setVgap(15);
        layout.setPadding(new Insets(20));

        layout.getChildren().addAll(wordInput, searchButton, meaningLabel);

        Scene scene = new Scene(layout, 320, 150);
        window.setTitle("Virtual Dictionary");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(DictionaryView.class);
    }
}