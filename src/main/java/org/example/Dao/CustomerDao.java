package org.example.Dao;

import org.example.HibernateUtil;
import org.example.entity.Borrowed;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDao {

    public void saveCustomer (Customer customer) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(customer);
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

    public List<Customer> getAllCustomers() {
        Session session = HibernateUtil.getSession();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
        session.close();
        return customers;
    }

    public Customer getById(Integer id) {
        Session session = HibernateUtil.getSession();
        Customer customer = session.find(Customer.class, id);
        session.close();
        return customer;
    }

    public void updateCustomer(Customer customer) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(customer);
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


   /* public void returnBook(Borrowed borrowed) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
//            session.createQuery("delete from Customer where bookList = :id", Customer.class).setParameter("id", borrowed);
            Query query = session.createQuery("delete booklist from Customer where bookList = :id");
            query.setParameter("id", borrowed);
            int result = query.executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }*/
}
