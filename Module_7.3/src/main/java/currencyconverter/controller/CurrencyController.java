package currencyconverter.controller;

import currencyconverter.dao.CurrencyDao;
import currencyconverter.entity.Currency;
import currencyconverter.view.AddCurrencyView;
import currencyconverter.view.CurrencyView;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    private void loadCurrenciesFromDatabase() {
        try {
            List<Currency> currencies = currencyDao.getAllCurrencies();
            if (currencies.isEmpty()) {
                view.setStatusMessage("Warning: No currencies found in database.", true);
                return;
            }

            view.getSourceCurrencyCombo().getItems().setAll(currencies);
            view.getTargetCurrencyCombo().getItems().setAll(currencies);

            view.getSourceCurrencyCombo().getSelectionModel().selectFirst();
            if (currencies.size() > 1) {
                view.getTargetCurrencyCombo().getSelectionModel().select(1);
            }

            view.setStatusMessage("Connected to database successfully via JPA.", false);
            view.getConvertButton().setDisable(false);
            view.getAddCurrencyButton().setDisable(false);

        } catch (Exception e) {
            view.setStatusMessage("JPA Database Error: Unable to fetch currencies.", true);
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

                if (abbr.isEmpty() || name.isEmpty()) {
                    addView.setStatus("Abbreviation and Name cannot be empty.");
                    return;
                }

                Currency newCurrency = new Currency(abbr, name, rate);
                currencyDao.addCurrency(newCurrency);

                addStage.close();
            } catch (NumberFormatException ex) {
                addView.setStatus("Invalid rate. Must be a numeric value.");
            } catch (Exception ex) {
                addView.setStatus("Database error: Could not save currency.");
            }
        });

        addStage.showAndWait();

        loadCurrenciesFromDatabase();
    }

    private void performConversion() {
        String input = view.getAmountInput().getText();
        if (input == null || input.isEmpty()) {
            view.setStatusMessage("Please enter an amount.", true);
            return;
        }

        try {
            double amount = Double.parseDouble(input);
            Currency source = view.getSourceCurrencyCombo().getValue();
            Currency target = view.getTargetCurrencyCombo().getValue();

            if (source == null || target == null) return;

            double sourceRate = currencyDao.getExchangeRate(source.getAbbreviation());
            double targetRate = currencyDao.getExchangeRate(target.getAbbreviation());

            double result = amount * (targetRate / sourceRate);
            view.getResultOutput().setText(String.format("%.2f %s", result, target.getAbbreviation()));
            view.setStatusMessage("Conversion successful.", false);

        } catch (NumberFormatException ex) {
            view.setStatusMessage("Invalid amount.", true);
        } catch (Exception ex) {
            view.setStatusMessage("JPA Error: Failed to fetch rates.", true);
        }
    }
}