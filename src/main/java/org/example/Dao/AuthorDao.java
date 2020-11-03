package org.example.Dao;

import org.example.HibernateUtil;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.tree.IdentNode;

import java.util.List;

public class AuthorDao {


    public List<Book> getAllBooks(Integer id) {
        Session sessionFactory = HibernateUtil.getSession();
        List<Book> books = null;

            Author author = sessionFactory.find(Author.class, id);
            books = author.getBookList();
            sessionFactory.close();
        return books;
    }

    public List<Author> getAllAuthors() {
        Session session = HibernateUtil.getSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();
        session.close();
        return  authors;
    }

    public Author getAuthorId(Integer id) {
        Session sessionFactory = HibernateUtil.getSession();
        Author author =  sessionFactory.find(Author.class, id);
        sessionFactory.close();
        return author;
    }

    public Author getAuthorName(String name) {
        Session session = HibernateUtil.getSession();
        Author author = session.createQuery("from Author where firstName = :name", Author.class).setParameter("name", name).getSingleResult();
        return author;
    }

    public void saveAuthor (Author author) {
        Session sessionFactory = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = sessionFactory.beginTransaction();
            sessionFactory.save(author);
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
