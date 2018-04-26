package src.sample;



//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene; // what changes within the stage - backed by a scene graph - contains the UI nodes - scenes make it easier to use a container
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage; // top level UI container in JavaFX - the window frame itself
import javafx.scene.Node;

//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Document;
//import java.io.FileOutputStream;

import java.io.IOException;
import static java.lang.Integer.parseInt;




public class Controller {

    // initialise values as 0's

    int standardAdultQuantity = 0;
    int vipAdultQuantity = 0;
    int standardStudentQuantity = 0;
    int vipStudentQuantity = 0;
    int standardChildQuantity = 0;
    int vipChildQuantity = 0;

    private int totalCost = 0;


    // import all the fx;id's for buttons and interactive elements

    @FXML
    private Button theMercy;
    @FXML
    private Button blackPanther;


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
    private GridPane seatingGrid;


    @FXML
    private Label amountDue;
    @FXML
    private Label changeDue;
    @FXML
    private TextField amountGivenField;

    @FXML
    private GridPane gridPane;

    //    @FXML
    //    private Rectangle seat;


    int amountGiven = 0;
    int change = 0;

    private int finalPrice = 0;

    // functions for moving between pages by loading new fxml files to the
    // scene which gets placed over the existing stage

    @FXML
    public void moveToTicket(ActionEvent event) throws IOException {

        //        Label bigTitle = new Label("Film Title");
        //        gridPane.add(bigTitle, 0, 2);

        //        Group myGroup = new Group();

        //        Parent ticket = FXMLLoader.load(getClass().getResource("ticketType.fxml"));


        //        myGroup.getChildren().add(bigTitle);
        //        myGroup.getChildren().add(ticket);


        Parent ticket = FXMLLoader.load(getClass().getResource("ticketType.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);


        //        @Override
        //        public void start(Stage primaryStage) {
        //            Group root = new Group();
        //            Scene scene = new Scene(root, 300, 130);
        //
        //            GridPane gridpane = new GridPane();
        //            gridpane.setHgap(10);
        //            gridpane.setVgap(10);
        //
        //            Label label = new Label("Label");
        //            gridpane.add(label, 0, 0);
        //
        //            root.getChildren().add(gridpane);
        //            primaryStage.setScene(scene);
        //            primaryStage.show();
        //        }

    }

    @FXML
    public void moveToTicketTheMercy(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypeTheMercy.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToTicketDarkestHour(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypeDarkestHour.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }

    @FXML
    public void moveToTicketEarlyMan(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypeEarlyMan.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToTicketTheGreatestShowman(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypeTheGreatestShowman.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToTicketPadMan(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypePadMan.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }



    @FXML
    public void moveToTicketCoco(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypeCoco.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }



    @FXML
    public void moveToTicketTheShapeOfWater(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypeTheShapeOfWater.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToTicketParis(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypeParis.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }

    @FXML
    public void moveToTicketPatelKiPunjabiShaadi(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketTypePatelKiPunjabiShaadi.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToSeatingTheMercy(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionTheMercy.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }

    @FXML
    public void moveToSeatingDarkestHour(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionDarkestHour.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }

    @FXML
    public void moveToSeatingEarlyMan(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionEarlyMan.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToSeatingtheGreatestShowman(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionTheGreatestShowman.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }

    @FXML
    public void moveToSeatingPadMan(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionPadMan.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }

    @FXML
    public void moveToSeatingCoco(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionCoco.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToSeatingTheShapeOfWater(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionTheShapeOfWater.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }


    @FXML
    public void moveToSeatingParis(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionParis.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }

    @FXML
    public void moveToSeatingPatelKiPunjabiShaadi(ActionEvent event) throws IOException {

        Parent ticket = FXMLLoader.load(getClass().getResource("seatSelectionPatelKiPunjabiShaadi.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);

    }




    @FXML
    public void backToMain(ActionEvent event) throws IOException {

        Parent main = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Scene mainScene = new Scene(main, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
    }


    @FXML
    public void moveToSeating(ActionEvent event) throws IOException {

        finalPrice = totalCost;

        Parent seat = FXMLLoader.load(getClass().getResource("seatSelection.fxml"));
        Scene seatingScene = new Scene(seat, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(seatingScene);

        //        TextField newField = new TextField();
        //        seatingGrid.getChildren().add(newField);
    }


    @FXML
    public void backToTicket(ActionEvent event) throws IOException {

        finalPrice = totalCost;

        Parent ticket = FXMLLoader.load(getClass().getResource("ticketType.fxml"));
        Scene ticketScene = new Scene(ticket, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(ticketScene);
    }


    @FXML
    public void proceedToPayment(ActionEvent event) throws IOException {

        finalPrice = 100;

        Parent payment = FXMLLoader.load(getClass().getResource("payment.fxml"));
        Scene paymentScene = new Scene(payment, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(paymentScene);


        //        amountDue.setText(String.valueOf(finalPrice));
    }

    @FXML
    public void backToSeatSelection(ActionEvent event) throws IOException {

        finalPrice = totalCost;

        Parent seat = FXMLLoader.load(getClass().getResource("seatSelection.fxml"));
        Scene seatingScene = new Scene(seat, 1165, 700);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(seatingScene);
    }


    @FXML
    public void seatSelected(ActionEvent event) throws IOException {

        //        seat.setFill

    }



    // functions to use the buttons to increase the quantity and calculate the cost


    @FXML
    public void standardAdult(ActionEvent event) {

        if (event.getSource().equals(plusButton1)) {
            standardAdultQuantity += 1;
        } else if (standardAdultQuantity > 0 && event.getSource().equals(minusButton1)) {
            standardAdultQuantity -= 1;
        }

        textField1.setText(String.valueOf(standardAdultQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));
    }

    @FXML
    public void vipAdult(ActionEvent event) {

        if (event.getSource().equals(plusButton2)) {
            vipAdultQuantity += 1;
        } else if (vipAdultQuantity > 0 && event.getSource().equals(minusButton2)) {
            vipAdultQuantity -= 1;
        }

        textField2.setText(String.valueOf(vipAdultQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }


    @FXML
    public void standardStudent(ActionEvent event) {

        if (event.getSource().equals(plusButton3)) {
            standardStudentQuantity += 1;
        } else if (standardStudentQuantity > 0 && event.getSource().equals(minusButton3)) {
            standardStudentQuantity -= 1;
        }

        textField3.setText(String.valueOf(standardStudentQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }

    @FXML
    public void vipStudent(ActionEvent event) {

        if (event.getSource().equals(plusButton4)) {
            vipStudentQuantity += 1;
        } else if (vipStudentQuantity > 0 && event.getSource().equals(minusButton4)) {
            vipStudentQuantity -= 1;
        }

        textField4.setText(String.valueOf(vipStudentQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }


    @FXML
    public void standardChild(ActionEvent event) {

        if (event.getSource().equals(plusButton5)) {
            standardChildQuantity += 1;
        } else if (standardChildQuantity > 0 && event.getSource().equals(minusButton5)) {
            standardChildQuantity -= 1;
        }

        textField5.setText(String.valueOf(standardChildQuantity));

        totalCost = (standardAdultQuantity * 10) + (vipAdultQuantity * 12) +
                (standardStudentQuantity * 7) + (vipStudentQuantity * 9) +
                (standardChildQuantity * 5) + (vipChildQuantity * 7);

        costField.setText(String.valueOf(totalCost));

    }


    @FXML
    public void vipChild(ActionEvent event) {

        if (event.getSource().equals(plusButton6)) {
            vipChildQuantity += 1;
        } else if (vipChildQuantity > 0 && event.getSource().equals(minusButton6)) {
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
        if (event.getSource().equals(datePicker)) {
            checkBox.setSelected(false);
        } else if (event.getSource().equals(checkBox)) {
            datePicker.setValue(null);
            checkBox.setSelected(true);
        }
    }



    // function to calculate the change to be given to the customer


    @FXML
    public void changeDue(ActionEvent event) {
        //        if(event.getSource())

        amountDue.setText(String.valueOf(finalPrice));


        amountGiven = parseInt(amountGivenField.getText());


        change = amountGiven - finalPrice;

        System.out.println(change);


        changeDue.setText(String.valueOf(change));
    }


    //function to generate the PDF ticket

    public void pdf() throws Exception {

//        Document ticket = new Document();
//        try {
//            PdfWriter.getInstance(ticket, new FileOutputStream("ticket.pdf"));
//            ticket.open();
//            Paragraph para = new Paragraph();
//
//            para.add("**************************************************");
//            para.add("*                                                *");
//            para.add("*                                                *");
//            para.add("********************  Ticket  ********************");
//            para.add("*                                                *");
//            para.add("*                                                *");
//            para.add("**************************************************");
//
//            ticket.add(para);
//            ticket.close();
//
//        } catch (DocumentException ex) {
//            ex.printStackTrace();
//        }

    }





}