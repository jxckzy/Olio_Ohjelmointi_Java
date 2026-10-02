package currencyconverter.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddCurrencyView {
    private final VBox root;
    private final TextField abbrInput;
    private final TextField nameInput;
    private final TextField rateInput;
    private final Button saveButton;
    private final Label statusLabel;

    public AddCurrencyView() {
        root = new VBox(12);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-font-family: 'Segoe UI', Arial, sans-serif; -fx-background-color: #f4f6f9;");

        Label title = new Label("Add New Currency");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        abbrInput = new TextField();
        abbrInput.setPromptText("Abbreviation (e.g. NOK)");

        nameInput = new TextField();
        nameInput.setPromptText("Name (e.g. Norwegian Krone)");

        rateInput = new TextField();
        rateInput.setPromptText("Rate against base (e.g. 10.5)");

        saveButton = new Button("Save to Database");
        saveButton.setMaxWidth(Double.MAX_VALUE);
        saveButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px;");

        statusLabel = new Label("");
        statusLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 12px;");

        root.getChildren().addAll(title, abbrInput, nameInput, rateInput, saveButton, statusLabel);
    }

    public Parent getRoot() { return root; }
    public TextField getAbbrInput() { return abbrInput; }
    public TextField getNameInput() { return nameInput; }
    public TextField getRateInput() { return rateInput; }
    public Button getSaveButton() { return saveButton; }
    public void setStatus(String text) { statusLabel.setText(text); }
}