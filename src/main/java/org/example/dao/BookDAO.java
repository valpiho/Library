package org.example.dao;

import org.example.entity.Book;

import java.util.List;

public interface BookDAO {

    Book getBook(int id);

    List<Book> getAllBooks();

    void addBook(Book book);

    void deleteBook(int id);
}
