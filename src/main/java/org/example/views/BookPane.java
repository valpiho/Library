package org.example.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.example.entity.Book;
import org.example.service.BookServiceImpl;

public class BookPane{

    private final BookServiceImpl bookServiceImpl = new BookServiceImpl();

    public BookPane() {}

    public Pane booksSample() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 0, 20, 20));

        borderPane.setBottom(addHBox());

        TableView<Book> bookTableView = new TableView<>();
        bookTableView.setEditable(true);

        // Name Column
        TableColumn<Book, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Description Column
        TableColumn<Book, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(200);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        bookTableView.setItems(getAllBooks());
        bookTableView.getColumns().addAll(nameColumn, descriptionColumn);

        borderPane.setLeft(bookTableView);

        return borderPane;
    }

    public HBox addHBox() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);

        Button buttonCreate = new Button("Create book");
        buttonCreate.setPrefSize(100, 20);

        Button buttonEdit = new Button("Edit book");
        buttonEdit.setPrefSize(100, 20);

        Button buttonDelete = new Button("Delete book");
        hBox.getChildren().addAll(buttonCreate, buttonEdit, buttonDelete);
        return hBox;
    }

    private ObservableList<Book> getAllBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(bookServiceImpl.getBook(1));
        System.out.println(books);
        return books;
    }
}
