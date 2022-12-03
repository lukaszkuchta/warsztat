package pl.sda.j133.hibernate.warsztat;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataAccessObject {
    public void insert(Object obiektDoWstawieniaDoBazy) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(obiektDoWstawieniaDoBazy);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }
}
