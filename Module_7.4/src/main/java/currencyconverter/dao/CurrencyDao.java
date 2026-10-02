package currencyconverter.dao;

import currencyconverter.datasource.MariaDbConnection;
import currencyconverter.entity.Currency;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CurrencyDao {

    public List<Currency> getAllCurrencies() throws Exception {
        EntityManager em = MariaDbConnection.getInstance().createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
        } finally {
            em.close();
        }
    }

    public double getExchangeRate(String abbreviation) throws Exception {
        EntityManager em = MariaDbConnection.getInstance().createEntityManager();
        try {
            Currency currency = em.find(Currency.class, abbreviation);
            if (currency == null) {
                throw new Exception("Currency not found: " + abbreviation);
            }
            return currency.getRate();
        } finally {
            em.close();
        }
    }

    public void addCurrency(Currency currency) throws Exception {
        EntityManager em = MariaDbConnection.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}