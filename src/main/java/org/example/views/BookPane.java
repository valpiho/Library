package org.example.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.dao.BookDAO;
import org.example.entity.Book;


public class BookPane{

    private final TableView<Book> bookTableView = new TableView<>();

    private final BookDAO bookDAO = new BookDAO();

    public BookPane() {}

    public Pane booksSample() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 0, 20, 20));

        bookTableView.setItems(getAllBooks());
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        borderPane.setLeft(bookTableView);
        borderPane.setBottom(hBox);

        // Name Column
        TableColumn<Book, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Description Column
        TableColumn<Book, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(200);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        bookTableView.getColumns().addAll(nameColumn, descriptionColumn);

        // Buttons
        Button buttonCreate = new Button("Create book");
        buttonCreate.setPrefSize(100, 20);
        buttonCreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();

                BorderPane borderPane = new BorderPane();
                borderPane.setPadding(new Insets(20, 0, 20, 20));

                HBox bookTitleBox = new HBox();
                bookTitleBox.setPadding(new Insets(15, 12, 15, 12));
                bookTitleBox.setSpacing(10);
                Label bookTitle = new Label("Book Title:");
                TextField bookTitleField = new TextField();
                bookTitleBox.getChildren().addAll(bookTitle, bookTitleField);

                HBox bookDescriptionBox = new HBox();
                bookDescriptionBox.setPadding(new Insets(15, 12, 15, 12));
                bookDescriptionBox.setSpacing(10);
                Label bookDescription = new Label("Description:");
                TextField bookDescriptionField = new TextField();
                bookDescriptionBox.getChildren().addAll(bookDescription, bookDescriptionField);

                HBox createBookBtnBox = new HBox();
                createBookBtnBox.setPadding(new Insets(15, 12, 15, 12));
                createBookBtnBox.setSpacing(10);
                Button btn = new Button("Save");
                btn.setPrefSize(100, 20);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        bookDAO.addBook(new Book(bookTitleField.getText(), bookDescriptionField.getText()));
                        stage.close();
                        bookTableView.setItems(getAllBooks());
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
        });

        Button buttonEdit = new Button("Edit book");
        buttonEdit.setPrefSize(100, 20);

        // Delete item
        Button buttonDelete = new Button("Delete book");
        buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bookDAO.deleteBook(bookTableView.getSelectionModel().getSelectedItem().getId());
                bookTableView.setItems(getAllBooks());
            }
        });
        hBox.getChildren().addAll(buttonCreate, buttonEdit, buttonDelete);
        return borderPane;
    }

    public ObservableList<Book> getAllBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.addAll(bookDAO.getAllBooks());
        return books;
    }
}
