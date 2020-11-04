package org.example.Dao;

import org.example.HibernateUtil;
import org.example.entity.Borrowed;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BorrowedDao {

    public void borrowBook(Borrowed borrowed) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(borrowed);
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

    public void returned(Borrowed borrowed) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(borrowed);
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
