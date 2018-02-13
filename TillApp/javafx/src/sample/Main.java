package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene; // what changes within the stage - backed by a scene graph - contains the UI nodes - scenes make it easier to use a container
import javafx.scene.layout.GridPane;
import javafx.stage.Stage; // top level UI container in Java - the window frame itself

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cine-Toucan");
        primaryStage.setScene(new Scene(root, 1165, 644));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
