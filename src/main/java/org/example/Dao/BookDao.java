package org.example.Dao;

import org.example.HibernateUtil;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao {

    public void saveBook(Book book) {
        Session sessionFactory = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = sessionFactory.beginTransaction();
            sessionFactory.save(book);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            sessionFactory.close();
        }


    }

}
