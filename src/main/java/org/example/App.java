package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.entity.Author;
import org.example.entity.Book;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Author author1 = new Author("Val", "Piho");
    Author author2 = new Author("John", "Doe");
    Author author3 = new Author("Mary", "Jane");

    @Override
    public void start(Stage stage){

        TabPane tabs = new TabPane();

        Tab bookTab = new Tab();
        bookTab.setText("Books");
        bookTab.setContent(booksSample());

        Tab authorTab = new Tab();
        authorTab.setText("Authors");
        authorTab.setContent(authorSample());

        Tab clientTab = new Tab();
        authorTab.setText("Clients");
        authorTab.setContent(null);

        tabs.getTabs().addAll(bookTab, authorTab);

        Scene scene = new Scene(tabs, 650,500);
        stage.setTitle("library");
        stage.setScene(scene);
        stage.show();
    }

    private Pane booksSample() {
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

    private Pane authorSample() {
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
    public ObservableList<Book> getAllBooks() {
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
    }

    public ObservableList<Author> getAllAuthors() {
        ObservableList<Author> authors = FXCollections.observableArrayList();
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        return authors;
    }
}
