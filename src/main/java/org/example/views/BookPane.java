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

public class BookPane{

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

        /*bookTableView.setItems(getAllBooks());
        bookTableView.getColumns().addAll(nameColumn, authorColumn, descriptionColumn);*/

        borderPane.setLeft(bookTableView);

        return borderPane;
    }

   /* private ObservableList<Book> getAllBooks() {

        Author author1 = new Author("Val", "Piho");
        Author author2 = new Author("John", "Doe");
        Author author3 = new Author("Mary", "Jane");
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("Java from Scratch",
                author1.getFullName(),
                "Some interesting book of Java"));
        books.add(new Book("Spring from Scratch",
                author2.getFullName(),
                "Some interesting book of Spring"));
        books.add(new Book("JavaFX from Scratch",
                author3.getFullName(),
                "Some interesting book of JavaFX"));
        return books;
    }*/
}
