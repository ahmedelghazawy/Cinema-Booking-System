package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.text.Text;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene; // what changes within the stage - backed by a scene graph - contains the UI nodes - scenes make it easier to use a container
import javafx.scene.layout.GridPane;
import javafx.stage.Stage; // top level UI container in JavaFX - the window frame itself

import javax.swing.*;
import java.awt.Window;


import javafx.scene.Node;
import javafx.stage.Stage;


import java.io.*;


public class Controller {

//    @FXML
//    private Parent second;
//    private Stage window;


    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        Parent second = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene secondScene = new Scene(second, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(secondScene);
    }


    @FXML
    public void backToMain(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene mainScene = new Scene(main, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
    }



}
