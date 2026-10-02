package currencyconverter.dao;

import currencyconverter.datasource.MariaDbConnection;
import currencyconverter.entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    public void persistTransaction(Transaction transaction) throws Exception {
        EntityManager em = MariaDbConnection.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}