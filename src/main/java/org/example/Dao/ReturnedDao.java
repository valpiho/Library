package org.example.Dao;

import org.example.HibernateUtil;
import org.example.entity.Customer;
import org.example.entity.Returned;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReturnedDao {

    public void returnBook (Returned returned) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(returned);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
}
