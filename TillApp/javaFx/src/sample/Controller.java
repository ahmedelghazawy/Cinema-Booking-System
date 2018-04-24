package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene; // what changes within the stage - backed by a scene graph - contains the UI nodes - scenes make it easier to use a container
import javafx.scene.control.*;
import javafx.stage.Stage; // top level UI container in JavaFX - the window frame itself
import javafx.scene.Node;
import java.io.*;



public class Controller {


    int standardAdultQuantity = 0;
    int vipAdultQuantity = 0;
    int standardStudentQuantity = 0;
    int vipStudentQuantity = 0;
    int standardChildQuantity = 0;
    int vipChildQuantity = 0;

    int totalCost = 0;


    @FXML
    private Button plusButton1;
    @FXML
    private TextField textField1;
    @FXML
    private Button minusButton1;

    @FXML
    private Button plusButton2;
    @FXML
    private TextField textField2;
    @FXML
    private Button minusButton2;

    @FXML
    private Button plusButton3;
    @FXML
    private TextField textField3;
    @FXML
    private Button minusButton3;

    @FXML
    private Button plusButton4;
    @FXML
    private TextField textField4;
    @FXML
    private Button minusButton4;

    @FXML
    private Button plusButton5;
    @FXML
    private TextField textField5;
    @FXML
    private Button minusButton5;

    @FXML
    private Button plusButton6;
    @FXML
    private TextField textField6;
    @FXML
    private Button minusButton6;

    @FXML
    private Label costField;


    @FXML
    private DatePicker datePicker;
    @FXML
    private CheckBox checkBox;




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





    @FXML
    public void standardAdult(ActionEvent event){

        if(event.getSource().equals(plusButton1)) {
            standardAdultQuantity += 1;
        } else if( standardAdultQuantity > 0 && event.getSource().equals(minusButton1)) {
            standardAdultQuantity -= 1;
        }

        textField1.setText(String.valueOf(standardAdultQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }

    @FXML
    public void vipAdult(ActionEvent event){

        if(event.getSource().equals(plusButton2)) {
            vipAdultQuantity += 1;
        } else if( vipAdultQuantity > 0 && event.getSource().equals(minusButton2)) {
            vipAdultQuantity -= 1;
        }

        textField2.setText(String.valueOf(vipAdultQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }


    @FXML
    public void standardStudent(ActionEvent event){

        if(event.getSource().equals(plusButton3)) {
            standardStudentQuantity += 1;
        } else if( standardStudentQuantity > 0 && event.getSource().equals(minusButton3)) {
            standardStudentQuantity -= 1;
        }

        textField3.setText(String.valueOf(standardStudentQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }

    @FXML
    public void vipStudent(ActionEvent event){

        if(event.getSource().equals(plusButton4)) {
            vipStudentQuantity += 1;
        } else if( vipStudentQuantity > 0 && event.getSource().equals(minusButton4)) {
            vipStudentQuantity -= 1;
        }

        textField4.setText(String.valueOf(vipStudentQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }


    @FXML
    public void standardChild(ActionEvent event){

        if(event.getSource().equals(plusButton5)) {
            standardChildQuantity += 1;
        } else if( standardChildQuantity > 0 && event.getSource().equals(minusButton5)) {
            standardChildQuantity -= 1;
        }

        textField5.setText(String.valueOf(standardChildQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }


    @FXML
    public void vipChild(ActionEvent event){

        if(event.getSource().equals(plusButton6)) {
            vipChildQuantity += 1;
        } else if( vipChildQuantity > 0 && event.getSource().equals(minusButton6)) {
            vipChildQuantity -= 1;
        }

        textField6.setText(String.valueOf(vipChildQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }

    @FXML
    public void daySelect(ActionEvent event) {
        if(event.getSource().equals(datePicker)){
            checkBox.setSelected(false);
        }
    }


    


}