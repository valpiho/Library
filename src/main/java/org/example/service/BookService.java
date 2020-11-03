package org.example.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.dao.BookDAO;
import org.example.entity.Book;


public class BookService {

    private final BookDAO bookDAO = new BookDAO();

    public void addBookWindow(HBox hBox) {
        Stage stage = new Stage();

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 0, 20, 20));



        HBox bookTitleBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        Label bookTitle = new Label("Book Title:");
        TextField bookTitleField = new TextField();
        bookTitleBox.getChildren().addAll(bookTitle, bookTitleField);

        HBox bookDescriptionBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        Label bookDescription = new Label("Description:");
        TextField bookDescriptionField = new TextField();
        bookDescriptionBox.getChildren().addAll(bookDescription, bookDescriptionField);

        HBox createBookBtnBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        Button btn = new Button("Save");
        btn.setPrefSize(100, 20);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bookDAO.addBook(new Book(bookTitleField.getText(), bookDescriptionField.getText()));
                stage.close();
            }
        });

        createBookBtnBox.getChildren().addAll(btn);

        VBox bookBox = new VBox();
        bookBox.getChildren().addAll(bookTitleBox,bookDescriptionBox, createBookBtnBox);
        borderPane.setCenter(bookBox);

        Scene scene = new Scene(new Group(borderPane), 300, 300);
        stage.setTitle("Add new book");
        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<Book> getAllBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.addAll(bookDAO.getAllBooks());
        return books;
    }
}
