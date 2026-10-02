package currencyconverter.datasource;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDbConnection {
    private static EntityManagerFactory emf = null;

    public static EntityManagerFactory getInstance() {
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory("CurrencyMariaDB");
            } catch (Exception e) {
                System.err.println("JPA Connection Failed: " + e.getMessage());
                throw e;
            }
        }
        return emf;
    }
}