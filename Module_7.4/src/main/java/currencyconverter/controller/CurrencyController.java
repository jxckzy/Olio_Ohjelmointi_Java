package currencyconverter.controller;

import currencyconverter.dao.CurrencyDao;
import currencyconverter.dao.TransactionDao;
import currencyconverter.entity.Currency;
import currencyconverter.entity.Transaction;
import currencyconverter.view.AddCurrencyView;
import currencyconverter.view.CurrencyView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class CurrencyController {

    private final CurrencyDao currencyDao;
    private final TransactionDao transactionDao;
    private final CurrencyView view;

    public CurrencyController(CurrencyDao currencyDao, CurrencyView view) {
        this.currencyDao = currencyDao;
        this.transactionDao = new TransactionDao();
        this.view = view;

        seedDatabaseIfEmpty();
        loadCurrenciesFromDatabase();
        attachEventHandlers();
    }

    // Seeds default currencies if empty (required because drop-and-create clears the DB on startup)
    private void seedDatabaseIfEmpty() {
        try {
            if (currencyDao.getAllCurrencies().isEmpty()) {
                currencyDao.addCurrency(new Currency("USD", "US Dollar", 1.0));
                currencyDao.addCurrency(new Currency("EUR", "Euro", 0.92));
                currencyDao.addCurrency(new Currency("GBP", "British Pound", 0.79));
            }
        } catch (Exception ignored) {}
    }

    private void loadCurrenciesFromDatabase() {
        try {
            List<Currency> currencies = currencyDao.getAllCurrencies();
            if (currencies.isEmpty()) return;

            view.getSourceCurrencyCombo().getItems().setAll(currencies);
            view.getTargetCurrencyCombo().getItems().setAll(currencies);

            view.getSourceCurrencyCombo().getSelectionModel().selectFirst();
            if (currencies.size() > 1) {
                view.getTargetCurrencyCombo().getSelectionModel().select(1);
            }

            view.setStatusMessage("Connected. Schema generated successfully.", false);
            view.getConvertButton().setDisable(false);
            view.getAddCurrencyButton().setDisable(false);

        } catch (Exception e) {
            view.setStatusMessage("JPA Error: Unable to fetch currencies.", true);
            view.getConvertButton().setDisable(true);
            view.getAddCurrencyButton().setDisable(true);
        }
    }

    private void attachEventHandlers() {
        view.getConvertButton().setOnAction(e -> performConversion());
        view.getAddCurrencyButton().setOnAction(e -> openAddCurrencyWindow());
    }

    private void openAddCurrencyWindow() {
        AddCurrencyView addView = new AddCurrencyView();
        Stage addStage = new Stage();
        addStage.setTitle("Add Currency");
        addStage.setScene(new Scene(addView.getRoot(), 300, 320));
        addStage.setResizable(false);

        addView.getSaveButton().setOnAction(e -> {
            try {
                String abbr = addView.getAbbrInput().getText().toUpperCase().trim();
                String name = addView.getNameInput().getText().trim();
                double rate = Double.parseDouble(addView.getRateInput().getText().trim());

                if (!abbr.isEmpty() && !name.isEmpty()) {
                    currencyDao.addCurrency(new Currency(abbr, name, rate));
                    addStage.close();
                } else {
                    addView.setStatus("Abbreviation and Name cannot be empty.");
                }
            } catch (Exception ex) {
                addView.setStatus("Error saving currency.");
            }
        });

        addStage.showAndWait();
        loadCurrenciesFromDatabase();
    }

    private void performConversion() {
        String input = view.getAmountInput().getText();
        if (input == null || input.isEmpty()) return;

        try {
            double amount = Double.parseDouble(input);
            Currency source = view.getSourceCurrencyCombo().getValue();
            Currency target = view.getTargetCurrencyCombo().getValue();

            if (source == null || target == null) return;

            double sourceRate = currencyDao.getExchangeRate(source.getAbbreviation());
            double targetRate = currencyDao.getExchangeRate(target.getAbbreviation());

            double result = amount * (targetRate / sourceRate);
            view.getResultOutput().setText(String.format("%.2f %s", result, target.getAbbreviation()));

            // Requirement: Save transaction to database via TransactionDao
            Transaction newTx = new Transaction(amount, source, target);
            transactionDao.persistTransaction(newTx);

            view.setStatusMessage("Conversion successful. Transaction saved.", false);

        } catch (NumberFormatException ex) {
            view.setStatusMessage("Invalid amount.", true);
        } catch (Exception ex) {
            view.setStatusMessage("Failed to save transaction to database.", true);
        }
    }
}