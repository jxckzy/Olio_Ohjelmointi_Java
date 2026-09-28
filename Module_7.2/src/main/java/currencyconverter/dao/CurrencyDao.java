package currencyconverter.dao;

import currencyconverter.datasource.MariaDbConnection;
import currencyconverter.entity.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    /**
     * Retrieves the exchange rate of a currency from the database by abbreviation.
     * @param abbreviation Currency code (e.g., "EUR", "USD")
     * @return conversion rate relative to base currency as double
     */
    public double getExchangeRate(String abbreviation) throws SQLException {
        String sql = "SELECT rate FROM currency WHERE abbreviation = ?";
        Connection conn = MariaDbConnection.getConnection();

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, abbreviation);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("rate");
                } else {
                    throw new SQLException("Currency not found in database: " + abbreviation);
                }
            }
        }
    }

    /**
     * Retrieves all available currencies from the database to populate the UI.
     */
    public List<Currency> getAllCurrencies() throws SQLException {
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT abbreviation, name, rate FROM currency";
        Connection conn = MariaDbConnection.getConnection();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String abbreviation = resultSet.getString("abbreviation");
                String name = resultSet.getString("name");
                double rate = resultSet.getDouble("rate");
                currencies.add(new Currency(abbreviation, name, rate));
            }
        }
        return currencies;
    }
}