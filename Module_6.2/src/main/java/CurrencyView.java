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
    private Label statusLabel;

    public CurrencyView() {
        root = new VBox(15);
        buildUI();
        applyStyling();
    }

    private void buildUI() {
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        Label titleLabel = new Label("Currency Converter");
        titleLabel.getStyleClass().add("header-title");

        Label instructionLabel = new Label("Enter an amount, select currencies, and click 'Convert'.");
        instructionLabel.getStyleClass().add("instruction-text");

        VBox headerBox = new VBox(5, titleLabel, instructionLabel);
        headerBox.setAlignment(Pos.CENTER);

        Label amountLabel = new Label("Amount to Convert:");
        amountInput = new TextField();
        amountInput.setPromptText("e.g. 100.00");
        configureNumericInputFilter(amountInput);

        VBox amountBox = new VBox(5, amountLabel, amountInput);

        Label sourceLabel = new Label("From Currency:");
        sourceCurrencyCombo = new ComboBox<>();
        sourceCurrencyCombo.setMaxWidth(Double.MAX_VALUE);
        VBox sourceBox = new VBox(5, sourceLabel, sourceCurrencyCombo);

        Label targetLabel = new Label("To Currency:");
        targetCurrencyCombo = new ComboBox<>();
        targetCurrencyCombo.setMaxWidth(Double.MAX_VALUE);
        VBox targetBox = new VBox(5, targetLabel, targetCurrencyCombo);

        GridPane selectorGrid = new GridPane();
        selectorGrid.setHgap(15);
        selectorGrid.setVgap(10);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        selectorGrid.getColumnConstraints().addAll(col1, col2);

        selectorGrid.add(sourceBox, 0, 0);
        selectorGrid.add(targetBox, 1, 0);

        convertButton = new Button("Convert");
        convertButton.setMaxWidth(Double.MAX_VALUE);
        convertButton.getStyleClass().add("convert-button");

        Label resultLabel = new Label("Converted Amount:");
        resultOutput = new TextField();
        resultOutput.setEditable(false);
        resultOutput.setPromptText("Result will appear here");
        resultOutput.getStyleClass().add("result-field");

        VBox resultBox = new VBox(5, resultLabel, resultOutput);

        statusLabel = new Label("");
        statusLabel.getStyleClass().add("status-label");

        root.getChildren().addAll(
                headerBox,
                amountBox,
                selectorGrid,
                convertButton,
                resultBox,
                statusLabel
        );
    }

    private void configureNumericInputFilter(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        };
        textField.setTextFormatter(new TextFormatter<>(new DoubleStringConverter(), null, filter));
    }

    private void applyStyling() {
        String css = """
            .root {
                -fx-font-family: 'Segoe UI', 'Helvetica Neue', Arial, sans-serif;
                -fx-background-color: #f4f6f9;
            }
            .header-title {
                -fx-font-size: 22px;
                -fx-font-weight: bold;
                -fx-text-fill: #1a252f;
            }
            .instruction-text {
                -fx-font-size: 13px;
                -fx-text-fill: #7f8c8d;
            }
            .label {
                -fx-font-size: 13px;
                -fx-font-weight: bold;
                -fx-text-fill: #2c3e50;
            }
            .text-field, .combo-box {
                -fx-font-size: 14px;
                -fx-padding: 8px;
                -fx-background-radius: 6px;
                -fx-border-radius: 6px;
                -fx-border-color: #bdc3c7;
                -fx-background-color: white;
            }
            .text-field:focused, .combo-box:focused {
                -fx-border-color: #3498db;
            }
            .convert-button {
                -fx-font-size: 15px;
                -fx-font-weight: bold;
                -fx-text-fill: white;
                -fx-background-color: #3498db;
                -fx-background-radius: 6px;
                -fx-padding: 10px;
                -fx-cursor: hand;
            }
            .convert-button:hover {
                -fx-background-color: #2980b9;
            }
            .result-field {
                -fx-background-color: #eaecee;
                -fx-font-weight: bold;
                -fx-text-fill: #27ae60;
            }
            .status-label {
                -fx-font-size: 12px;
                -fx-font-weight: bold;
                -fx-text-fill: #e74c3c;
            }
        """;
        root.getStylesheets().add("data:text/css," + css.replaceAll("\n", " "));
    }

    public Parent getRoot() {
        return root;
    }

    public TextField getAmountInput() {
        return amountInput;
    }

    public TextField getResultOutput() {
        return resultOutput;
    }

    public ComboBox<Currency> getSourceCurrencyCombo() {
        return sourceCurrencyCombo;
    }

    public ComboBox<Currency> getTargetCurrencyCombo() {
        return targetCurrencyCombo;
    }

    public Button getConvertButton() {
        return convertButton;
    }

    public void setStatusMessage(String message, boolean isError) {
        statusLabel.setText(message);
        if (isError) {
            statusLabel.setStyle("-fx-text-fill: #e74c3c;");
        } else {
            statusLabel.setStyle("-fx-text-fill: #27ae60;");
        }
    }
}