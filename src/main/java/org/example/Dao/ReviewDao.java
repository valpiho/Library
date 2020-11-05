package org.example.Dao;

import org.example.HibernateUtil;
import org.example.entity.Book;
import org.example.entity.Customer;
import org.example.entity.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ReviewDao {

    public void saveReview (Review review) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(review);
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

    public void updateReview (Review review) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(review);
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

    public Review getByBookNameAndAuthorName(Book book, Customer customer) {
        Session session = HibernateUtil.getSession();
        Review review = session.createQuery("from Review where bookRev = :book and customer = :customer",Review.class )
                                            .setParameter("book", book).setParameter("customer", customer).getSingleResult();
        session.close();
        return review;
    }

    public void deleteReview (Review review) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(review);
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

    public Review getById(Integer id) {
        Session session = HibernateUtil.getSession();
        Review review = session.find(Review.class, id);
        session.close();
        return review;
    }

}
