package currencyconverter.controller;

import currencyconverter.dao.CurrencyDao;
import currencyconverter.entity.Currency;
import currencyconverter.view.CurrencyView;

import java.sql.SQLException;
import java.util.List;

public class CurrencyController {

    private final CurrencyDao currencyDao;
    private final CurrencyView view;

    public CurrencyController(CurrencyDao currencyDao, CurrencyView view) {
        this.currencyDao = currencyDao;
        this.view = view;

        loadCurrenciesFromDatabase();
        attachEventHandlers();
    }

    /**
     * Loads currencies from database into UI dropdowns without hardcoded rates.
     */
    private void loadCurrenciesFromDatabase() {
        try {
            List<Currency> currencies = currencyDao.getAllCurrencies();
            if (currencies.isEmpty()) {
                view.setStatusMessage("Warning: No currencies found in database.", true);
                return;
            }

            view.getSourceCurrencyCombo().getItems().setAll(currencies);
            view.getTargetCurrencyCombo().getItems().setAll(currencies);

            view.getSourceCurrencyCombo().getSelectionModel().select(0);
            if (currencies.size() > 1) {
                view.getTargetCurrencyCombo().getSelectionModel().select(1);
            }
            view.setStatusMessage("Connected to database successfully.", false);

        } catch (SQLException e) {
            // Displays error message if database is not available without crashing
            view.setStatusMessage("Database Connection Error: Unable to fetch currencies from database.", true);
            view.getConvertButton().setDisable(true);
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

            // Fetch exchange rates from database via CurrencyDao method
            double sourceRate = currencyDao.getExchangeRate(source.getAbbreviation());
            double targetRate = currencyDao.getExchangeRate(target.getAbbreviation());

            // Compute conversion
            double convertedResult = amount * (targetRate / sourceRate);

            view.getResultOutput().setText(String.format("%.2f %s", convertedResult, target.getAbbreviation()));
            view.setStatusMessage("Conversion successful.", false);

        } catch (NumberFormatException ex) {
            view.setStatusMessage("Invalid numeric input. Please enter a valid number.", true);
            view.getResultOutput().clear();
        } catch (SQLException ex) {
            // Displays appropriate UI error if DB connection fails mid-operation
            view.setStatusMessage("Database Error: Failed to retrieve rates from database.", true);
            view.getResultOutput().clear();
        }
    }
}