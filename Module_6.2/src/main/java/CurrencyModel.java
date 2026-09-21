import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {
    private final List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();
        initializeDefaultCurrencies();
    }

    private void initializeDefaultCurrencies() {
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.92));
        currencies.add(new Currency("GBP", "British Pound", 0.79));
        currencies.add(new Currency("JPY", "Japanese Yen", 155.50));
        currencies.add(new Currency("CAD", "Canadian Dollar", 1.36));
        currencies.add(new Currency("AUD", "Australian Dollar", 1.51));
        currencies.add(new Currency("CHF", "Swiss Franc", 0.91));
        currencies.add(new Currency("INR", "Indian Rupee", 83.30));
        currencies.add(new Currency("UAH", "Ukrainian Hryvnia", 44.65));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency fromCurrency, Currency toCurrency) {
        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Source and target currencies must be specified.");
        }
        double amountInUSD = amount / fromCurrency.getRateToUSD();
        return amountInUSD * toCurrency.getRateToUSD();
    }
}