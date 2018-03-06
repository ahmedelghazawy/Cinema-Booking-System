package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
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


    @FXML
    private Parent second;
    private Stage window;


    @FXML
    public void moveToTicket(ActionEvent event) throws IOException {
        Parent ticket = FXMLLoader.load(getClass().getResource("ticketType.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);
    }


    @FXML
    public void backToMain(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Scene mainScene = new Scene(main, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
    }


    @FXML
    public void moveToSeating(ActionEvent event) throws IOException {
        Parent seat = FXMLLoader.load(getClass().getResource("seatSelection.fxml"));
        Scene seatingScene = new Scene(seat, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(seatingScene);
    }


    @FXML
    public void backToTicket(ActionEvent event) throws IOException {
        Parent ticket = FXMLLoader.load(getClass().getResource("ticketType.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);
    }


    @FXML
    public void proceedToPayment(ActionEvent event) throws IOException {
        Parent payment = FXMLLoader.load(getClass().getResource("payment.fxml"));
        Scene paymentScene = new Scene(payment, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(paymentScene);
    }

    @FXML
    public void backToSeatSelection(ActionEvent event) throws IOException {
        Parent seat = FXMLLoader.load(getClass().getResource("seatSelection.fxml"));
        Scene seatingScene = new Scene(seat, 1165, 700);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(seatingScene);
    }


    @FXML
    public void seatSelected(ActionEvent event) throws IOException {

    }

}
