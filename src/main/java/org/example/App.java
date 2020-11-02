package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import org.example.views.AuthorPane;
import org.example.views.BookPane;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    BookPane bookPane = new BookPane();
    AuthorPane authorPane = new AuthorPane();

    @Override
    public void start(Stage stage){

        TabPane tabs = new TabPane();

        Tab bookTab = new Tab();
        bookTab.setText("Books");
        bookTab.setContent(bookPane.booksSample());

        Tab authorTab = new Tab();
        authorTab.setText("Authors");
        authorTab.setContent(authorPane.authorSample());

        Tab clientTab = new Tab();
        clientTab.setText("Clients");
        clientTab.setContent(null);

        tabs.getTabs().addAll(bookTab, authorTab, clientTab);

        Scene scene = new Scene(tabs, 650,500);
        stage.setTitle("library");
        stage.setScene(scene);
        stage.show();
    }


}
