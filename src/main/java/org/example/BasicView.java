package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.Dao.AuthorDao;
import org.example.Dao.BookDao;
import org.example.Dao.CustomerDao;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class BasicView {

    //FXMLs//
    //authorTab//
    @FXML
    private TextField auBookNameForCreate, auBookDescForCreate, auBookNameForEdit, auBookDescForEdit,
                        auBookIdForDeleteOrGet, auNameForGetAllBooksAndReviews, auBookIdForEdit, auBookAuthorIdForCreate;

    @FXML
    private Button auCreateBook, auEditBook, auDeleteBook, auGetBook, auGetAllBooks, auGetAllReviews;

    @FXML
    private ListView auTextAreaForAll;
    //authorTab//

    //customerTab//
    @FXML
    private TextField cuBookNameForBorrowAndReturnAndEdit, cuReviewForCreateAndEdit, cuBookNameForGetReviewAndReviews,
                        cuBookNameForDelete;

    @FXML
    private Button cuBorrowBook, cuReturnBook, cuCreateReview, cuEditReview, cuGetBookReview, cuGetBooksReview,
                    cuDeleteBookReview;

    @FXML
    private TextArea cuTextAreaForAll;
    //customerTab//

    //reviewsTab//
    @FXML
    private  TextField revBookNameForReviews;

    @FXML
    private Button revCheckForReviews;

    @FXML
    private TextArea revTextAreaForReviews;
    //reviewsTab//

    //registrationTab//
    @FXML
    private TextField regAuthorFirstName, regAuthorLastName, regCustomerFirstName, regCustomerLastName;

    @FXML
    private Button regCreateAuthor, regCreateCustomer, regGetAllAuthors, gerGetAllCustomers;

    @FXML
    private ListView regGetAllView;

    //registrationTab//
    //FXMLs//

    BookDao bookDao = new BookDao();
    AuthorDao authorDao = new AuthorDao();
    CustomerDao customerDao = new CustomerDao();

    //registrationTab//

    public void addAuthor(ActionEvent event) {
        String auFirstName = regAuthorFirstName.getText();
        String auLastName = regAuthorLastName.getText();

        Author author = new Author(auFirstName, auLastName);
        authorDao.saveAuthor(author);
    }

    public void getAllAuthors() {
        List<Author> authors = authorDao.getAllAuthors();
        ObservableList<Author> list = FXCollections.observableList(authors);
        regGetAllView.setItems(list);
    }

    public void addCustomer() {
        String cusFirstName = regCustomerFirstName.getText();
        String cusLastName = regCustomerLastName.getText();
        Customer customer = new Customer(cusFirstName, cusLastName);
        customerDao.saveCustomer(customer);
    }

    public void getAllCustomers() {
        regGetAllView.refresh();
        List<Customer> customers = customerDao.getAllCustomers();
        ObservableList<Customer> customers1 = FXCollections.observableList(customers);
        regGetAllView.setItems(customers1);
    }
    //registrationTab//

    //AuthorTab//
    public void getBooksByAuthorName() {
        Author author = authorDao.getAuthorName(auNameForGetAllBooksAndReviews.getText());
        List<Book> list = author.getBookList();
        ObservableList<Book> list1 = FXCollections.observableList(list);
        auTextAreaForAll.setItems(list1);
    }

    public void editBook() {
        Integer bookID = Integer.parseInt(auBookIdForEdit.getText());
        String bookName = auBookNameForEdit.getText();
        String bookDesc = auBookDescForEdit.getText();
        Book book = bookDao.getBookId(bookID);
        book.setName(bookName);
        book.setDescription(bookDesc);
        bookDao.updateBook(book);
    }

    public void addBook() {
        String bookName = auBookNameForCreate.getText();
        String bookDesc = auBookDescForCreate.getText();
        Integer auID = Integer.parseInt(auBookAuthorIdForCreate.getText());

        Book book = new Book(bookName, authorDao.getAuthorId(auID), bookDesc);
        bookDao.saveBook(book);
    }

    public void getBook() {
        Integer bookId = Integer.parseInt(auBookIdForDeleteOrGet.getText());
        Book book = bookDao.getBookId(bookId);
        List<Book> books = new ArrayList<>();
        books.add(book);
        ObservableList<Book> bookObservableList = FXCollections.observableList(books);
        auTextAreaForAll.setItems(bookObservableList);
    }

    public void deleteBook() {
        Integer bookId = Integer.parseInt(auBookIdForDeleteOrGet.getText());
        Book book = bookDao.getBookId(bookId);
        bookDao.deleteBook(book);
    }

    public void getAllReviewsAu() {
        //todo
    }

    //AuthorTab//


}
