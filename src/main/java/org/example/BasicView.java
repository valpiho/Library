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
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
    private TextArea auTextAreaForAll;
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


//    Session session = HibernateUtil.getSession();
//    Transaction transaction = null;
    BookDao bookDao = new BookDao();
    AuthorDao authorDao = new AuthorDao();

    public void addBook() {
        String bookName = auBookNameForCreate.getText();
        String bookDesc = auBookDescForCreate.getText();
        Integer auID = Integer.parseInt(auBookAuthorIdForCreate.getText());

        Book book = new Book(bookName, authorDao.getAuthorId(auID), bookDesc);
        bookDao.saveBook(book);
    }

    public void addAuthor(ActionEvent event) {
        String auFirstName = regAuthorFirstName.getText();
        String auLastName = regAuthorLastName.getText();

        Author author = new Author(auFirstName, auLastName);
        authorDao.saveAuthor(author);
    }

    public void getAllBooks() {
        auTextAreaForAll.clear();
        Author author = authorDao.getAuthorId(Integer.parseInt(auBookAuthorIdForCreate.getText()));
        List<Book> list = author.getBookList();
        for( Book b : list) {
            auTextAreaForAll.appendText(b.toString() + "\n");
        }

    }

    public void getBooksByAuthorName() {
        auTextAreaForAll.clear();
        Author author = authorDao.getAuthorName(auNameForGetAllBooksAndReviews.getText());
        List<Book> list = author.getBookList();
        for( Book b : list) {
            auTextAreaForAll.appendText(b.toString() + "\n");
        }
    }

    public void getAllAuthors() {
        List<Author> authors = authorDao.getAllAuthors();
        ObservableList<Author> list = FXCollections.observableList(authors);
        regGetAllView.setItems(list);
    }

}
