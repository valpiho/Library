package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entity.Author;
import org.hibernate.Session;


import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;




    @Override
    public void start(Stage stage) throws IOException {
        Parent fxmlLoader = new FXMLLoader().load(getClass().getResource("BasicView.fxml"));
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
//        BasicView basicView = new BasicView();
//        basicView.run();
    }



    public static void main(String[] args) {
        launch();
    }

}