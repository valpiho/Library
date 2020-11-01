package org.example.service;

import org.example.entity.Book;

import java.util.List;

public interface BookService {

    Book getBook(int id);

    List<Book> getAllBooks();

    void addBook(Book book);

    void deleteBook(int id);
}
