public class CurrencyController {

    private final CurrencyModel model;
    private final CurrencyView view;

    public CurrencyController(CurrencyModel model, CurrencyView view) {
        this.model = model;
        this.view = view;

        initializeViewData();
        attachEventHandlers();
    }

    private void initializeViewData() {
        view.getSourceCurrencyCombo().getItems().addAll(model.getCurrencies());
        view.getTargetCurrencyCombo().getItems().addAll(model.getCurrencies());

        if (!model.getCurrencies().isEmpty()) {
            view.getSourceCurrencyCombo().getSelectionModel().select(0); // USD
            if (model.getCurrencies().size() > 1) {
                view.getTargetCurrencyCombo().getSelectionModel().select(1); // EUR
            }
        }
    }

    private void attachEventHandlers() {
        view.getConvertButton().setOnAction(e -> performConversion());
    }

    private void performConversion() {
        String rawInput = view.getAmountInput().getText();

        if (rawInput == null || rawInput.trim().isEmpty()) {
            view.setStatusMessage("Please enter an amount to convert.", true);
            view.getResultOutput().clear();
            return;
        }

        try {
            double amount = Double.parseDouble(rawInput);

            if (amount < 0) {
                view.setStatusMessage("Amount cannot be negative.", true);
                view.getResultOutput().clear();
                return;
            }

            Currency source = view.getSourceCurrencyCombo().getValue();
            Currency target = view.getTargetCurrencyCombo().getValue();

            if (source == null || target == null) {
                view.setStatusMessage("Please select both source and target currencies.", true);
                return;
            }

            double result = model.convert(amount, source, target);

            view.getResultOutput().setText(String.format("%.2f %s", result, target.getCode()));
            view.setStatusMessage("Conversion successful.", false);

        } catch (NumberFormatException ex) {
            view.setStatusMessage("Invalid numeric input. Please enter a valid number.", true);
            view.getResultOutput().clear();
        } catch (Exception ex) {
            view.setStatusMessage("An unexpected error occurred: " + ex.getMessage(), true);
        }
    }
}