package currencyconverter.view;

import currencyconverter.entity.Currency;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.converter.DoubleStringConverter;

import java.util.function.UnaryOperator;

public class CurrencyView {
    private final VBox root;
    private TextField amountInput;
    private TextField resultOutput;
    private ComboBox<Currency> sourceCurrencyCombo;
    private ComboBox<Currency> targetCurrencyCombo;
    private Button convertButton;
    private Button addCurrencyButton;
    private Label statusLabel;

    public CurrencyView() {
        root = new VBox(16);
        buildUI();
    }

    private void buildUI() {
        root.setPadding(new Insets(24));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-font-family: 'Segoe UI', Arial, sans-serif; -fx-background-color: #f4f6f9;");

        Label titleLabel = new Label("Currency Converter");
        titleLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        Label amountLabel = new Label("Amount to Convert:");
        amountInput = new TextField();
        amountInput.setPromptText("e.g. 100.00");
        configureNumericInputFilter(amountInput);
        VBox amountBox = new VBox(5, amountLabel, amountInput);

        Label sourceLabel = new Label("From:");
        sourceCurrencyCombo = new ComboBox<>();
        sourceCurrencyCombo.setMaxWidth(Double.MAX_VALUE);
        VBox sourceBox = new VBox(5, sourceLabel, sourceCurrencyCombo);

        Label targetLabel = new Label("To:");
        targetCurrencyCombo = new ComboBox<>();
        targetCurrencyCombo.setMaxWidth(Double.MAX_VALUE);
        VBox targetBox = new VBox(5, targetLabel, targetCurrencyCombo);

        GridPane selectorGrid = new GridPane();
        selectorGrid.setHgap(12);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        selectorGrid.getColumnConstraints().addAll(col1, col2);
        selectorGrid.add(sourceBox, 0, 0);
        selectorGrid.add(targetBox, 1, 0);

        convertButton = new Button("Convert");
        convertButton.setMaxWidth(Double.MAX_VALUE);
        convertButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px;");

        addCurrencyButton = new Button("+ Add New Currency");
        addCurrencyButton.setMaxWidth(Double.MAX_VALUE);
        addCurrencyButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px;");

        Label resultLabel = new Label("Result:");
        resultOutput = new TextField();
        resultOutput.setEditable(false);
        resultOutput.setStyle("-fx-background-color: #eaecee; -fx-font-weight: bold;");
        VBox resultBox = new VBox(5, resultLabel, resultOutput);

        statusLabel = new Label("");
        statusLabel.setWrapText(true);

        root.getChildren().addAll(
                titleLabel, amountBox, selectorGrid,
                convertButton, addCurrencyButton, resultBox, statusLabel
        );
    }

    private void configureNumericInputFilter(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*(\\.\\d*)?")) return change;
            return null;
        };
        textField.setTextFormatter(new TextFormatter<>(new DoubleStringConverter(), null, filter));
    }

    public Parent getRoot() { return root; }
    public TextField getAmountInput() { return amountInput; }
    public TextField getResultOutput() { return resultOutput; }
    public ComboBox<Currency> getSourceCurrencyCombo() { return sourceCurrencyCombo; }
    public ComboBox<Currency> getTargetCurrencyCombo() { return targetCurrencyCombo; }
    public Button getConvertButton() { return convertButton; }
    public Button getAddCurrencyButton() { return addCurrencyButton; }

    public void setStatusMessage(String message, boolean isError) {
        statusLabel.setText(message);
        statusLabel.setStyle(isError ? "-fx-text-fill: #e74c3c; -fx-font-weight: bold;" : "-fx-text-fill: #27ae60; -fx-font-weight: bold;");
    }
}