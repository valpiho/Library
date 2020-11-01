package org.example.dao;

import org.example.config.HibernateUtils;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAOImpl implements BookDAO{

    @Override
    public Book getBook(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Book book = session.find(Book.class, id);
        session.close();
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<Book> bookQuery = session.createQuery("from Book");
        List<Book> bookList = bookQuery.getResultList();
        session.close();
        return bookList;

    }

    @Override
    public void addBook(Book book) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();

    }

    @Override
    public void deleteBook(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.find(Book.class, id);
        if (book != null){
            session.delete(book);
        }
        transaction.commit();
        session.close();
    }
}