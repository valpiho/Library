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

public class AuthorPane {

    Author author1 = new Author("Val", "Piho");
    Author author2 = new Author("John", "Doe");
    Author author3 = new Author("Mary", "Jane");

    public Pane authorSample() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 0, 20, 20));

        TableView<Author> bookTableView = new TableView<>();
        bookTableView.setEditable(true);

        // Name Column
        TableColumn<Author, String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setMinWidth(200);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        // Author Column
        TableColumn<Author, String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        bookTableView.setItems(getAllAuthors());
        bookTableView.getColumns().addAll(firstNameColumn, lastNameColumn);

        borderPane.setLeft(bookTableView);

        return borderPane;
    }


    private ObservableList<Author> getAllAuthors() {

        ObservableList<Author> authors = FXCollections.observableArrayList();
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        return authors;
    }
}
