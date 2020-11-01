package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.entity.Author;
import org.example.entity.Book;

import java.io.IOException;

public class App extends Application {

    private final TableView<Book> bookTableView = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        Scene scene = new Scene(new Group());
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setTitle("library");

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

        bookTableView.setItems(getAllBook());
        bookTableView.getColumns().addAll(nameColumn, authorColumn, descriptionColumn);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().addAll(bookTableView);

        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<Book> getAllBook() {
        ObservableList<Book> books = FXCollections.observableArrayList();

        Author author1 = new Author("Val", "Piho");
        Author author2 = new Author("John", "Doe");
        Author author3 = new Author("Mary", "Jane");

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
}
