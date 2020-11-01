package org.example.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.BookService;

public class BookPane{

    private BookService bookService;

    public BookPane() {}

    public BookPane(BookService bookService) {
        this.bookService = bookService;
    }

    public Pane booksSample() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 0, 20, 20));

        TableView<Book> bookTableView = new TableView<>();
        bookTableView.setEditable(true);

        // Name Column
        TableColumn<Book, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Author Column
        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(200);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("authorName"));

        // Description Column
        TableColumn<Book, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(200);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        bookTableView.setItems(getAllBooks());
        bookTableView.getColumns().addAll(nameColumn, authorColumn, descriptionColumn);

        borderPane.setLeft(bookTableView);

        return borderPane;
    }

    private ObservableList<Book> getAllBooks() {

        ObservableList<Book> books = FXCollections.observableArrayList();
        books.addAll(bookService.getAllBooks());
        return books;
    }
}
