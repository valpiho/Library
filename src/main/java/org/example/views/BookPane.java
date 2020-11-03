package org.example.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.example.entity.Book;
import org.example.service.BookService;

public class BookPane{

    private final BookService bookService = new BookService();
    private final TableView<Book> bookTableView = new TableView<>();

    public BookPane() {}

    public Pane booksSample() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 0, 20, 20));



        // Name Column
        TableColumn<Book, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Description Column
        TableColumn<Book, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(200);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Buttons
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);

        Button buttonCreate = new Button("Create book");
        buttonCreate.setPrefSize(100, 20);
        buttonCreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bookService.addBookWindow(hBox);
                bookTableView.setItems(bookService.getAllBooks());
            }
        });

        Button buttonEdit = new Button("Edit book");
        buttonEdit.setPrefSize(100, 20);

        Button buttonDelete = new Button("Delete book");
        hBox.getChildren().addAll(buttonCreate, buttonEdit, buttonDelete);

        bookTableView.setEditable(true);
        bookTableView.setItems(bookService.getAllBooks());
        bookTableView.getColumns().addAll(nameColumn, descriptionColumn);

        borderPane.setLeft(bookTableView);
        borderPane.setBottom(hBox);
        return borderPane;
    }
}
