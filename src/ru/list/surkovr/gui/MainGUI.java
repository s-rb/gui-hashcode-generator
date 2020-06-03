package ru.list.surkovr.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));
        primaryStage.setTitle("Hashcode generator");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 395, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
